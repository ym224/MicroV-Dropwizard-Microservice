package service;

import dao.*;
import model.Dto.EventDto;
import model.Dto.ZipCodeDistance;
import model.EventInterest;

import java.math.BigDecimal;
import java.util.*;

public class RecommendationService {

    private ZipCodeDistanceService zipCodeDistanceService;
    private EventInterestDAO eventInterestDAO;
    private UserWishListDAO userWishListDAO;
    private UserInterestDAO userInterestDAO;
    private UserPreferenceDAO userPreferenceDAO;
    private EventDAO eventDAO;

    public RecommendationService( ZipCodeDistanceService zipCodeDistanceService,
                                  EventInterestDAO eventInterestDAO, UserWishListDAO userWishListDAO,
                                  UserInterestDAO userInterestDAO, EventDAO eventDAO,
                                 UserPreferenceDAO userPreferenceDAO) {
        this.eventInterestDAO = eventInterestDAO;
        this.userWishListDAO = userWishListDAO;
        this.userInterestDAO = userInterestDAO;
        this.userPreferenceDAO = userPreferenceDAO;
        this.eventDAO = eventDAO;
        this.zipCodeDistanceService = zipCodeDistanceService;
    }

    public List<EventDto> recommendEventsForUser(long userId) {
        List<Long> filteredEventIds = filterEventsByPreference(userId);

        // get event ids in user wish list
        List<Long> eventIds = userWishListDAO.getEventIdsByUserId(userId);

        // if no items in user wish list, return events based on his interests, filtered by location
        if (eventIds.isEmpty()) {
            List<EventDto> events =  eventInterestDAO.getRelevantEventsForUser(userId, filteredEventIds);

            // get interest names of events
            events.forEach(event->event.setTags(eventInterestDAO.getInterestNamesForEvent(event.getId())));

            return events;
        }

        List<EventInterest> eventInterests = eventInterestDAO.getByEventIds(eventIds);

        // for events in wishlist, compute and adjust weights
        Map<Long, Double> eventInterestsMap = new HashMap<>();
        for (EventInterest event : eventInterests) {
            eventInterestsMap.put(event.getInterestId(),
                    (eventInterestsMap.getOrDefault(event.getInterestId(), 0.0) + 1) / eventInterests.size());
        }

        // for each interest in map, update weight for user
        Iterator it = eventInterestsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, Double> pair = (Map.Entry) it.next();
            System.out.println("updating interest weights with id " + pair.getKey() + " and weight " + pair.getValue());
            // update weights of interest
            userInterestDAO.updateInterestWeights(userId, pair.getKey(), new BigDecimal(pair.getValue()));
        }

        // remove events already in user wishlist
        filteredEventIds.removeAll(eventIds);
        if (filteredEventIds.isEmpty()) return new ArrayList<>();
        // display events based on weighted user interests
        List<EventDto> events = eventInterestDAO.getRelevantEventsForUserWeighted(userId, filteredEventIds);

        // get interest names for each event
        events.forEach(event->event.setTags(eventInterestDAO.getInterestNamesForEvent(event.getId())));

        return events;
    }

/*    private List<Event> displayWeightedInterests(Long userId){
        // find all events relevant to user interest
        List<Event> eventInterests = eventInterestDAO.getRelevantEventsForUserWeighted(userId);

        // for each event, count frequency of interest id and place in map
        Map<Long, Integer> eventToInterestCounts = new HashMap<>();
        for (Event event: eventInterests) {
            // need to multiply interest count by user interest weight
            eventToInterestCounts.put(event.getEventId(),
                    eventToInterestCounts.getOrDefault(event.getEventId(), 0) + 1);
        }
        // sort map based on counts
        TreeMap<Long, Integer> sortedMap = sortMapByValue(eventToInterestCounts);
        List<Long> sortedEventIds = new ArrayList<>();
        sortedEventIds.addAll(sortedMap.keySet());
    }*/

    public List<Long> filterEventsByPreference(long userId){
        // find list of event ids matching user's time preferences
        List<EventDto> events = eventDAO.getEventIdsAndZipCodesByTime(userId);

        // get user's zip code
        Map<String, Integer> rangeAndZipCode = userPreferenceDAO.getPreferredRangeAndZipCode(userId);

        String zipCode = rangeAndZipCode.keySet().iterator().next();
        Integer range = rangeAndZipCode.values().iterator().next();

        if (zipCode != null && range != null) {

            // for each event id, calculate distance based on zipcode
            // remove events outside distance range
            Iterator<EventDto> it = events.iterator();
            while (it.hasNext()) {
                System.out.println("computing zipcode based distance");
                ZipCodeDistance distance = zipCodeDistanceService.callZipCodeAPI(zipCode, it.next().getZipCode());
                double distanceNum = distance.getDistance();
                if (distanceNum >= range) {
                    it.remove();
                }
            }
        }
        List<Long> filteredEventIds = new ArrayList<>();
        events.forEach(event ->filteredEventIds.add(event.getId()));
        return filteredEventIds;
    }

    public static TreeMap<Long, Integer> sortMapByValue(Map<Long, Integer> map) {
        Comparator<Long> comparator = new ValueComparator(map);
        TreeMap<Long, Integer> result = new TreeMap<>(comparator);
        result.putAll(map);
        return result;
    }


    static class ValueComparator implements Comparator<Long> {
        Map<Long, Integer> map = new HashMap<>();

        public ValueComparator(Map<Long, Integer> map) {
            this.map.putAll(map);
        }

        @Override
        public int compare(Long l1, Long l2) {
            if (map.get(l1) >= map.get(l2)) {
                return -1;
            } else {
                return 1;
            }
        }

    }
}
