package dao;

import mapper.EventInterestMapper;
import mapper.EventMapper;
import model.Dto.EventDto;
import model.EventInterest;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.skife.jdbi.v2.unstable.BindIn;

import java.sql.Timestamp;
import java.util.List;

@UseStringTemplate3StatementLocator
@RegisterMapper(EventInterestMapper.class)
public interface EventInterestDAO {

    @SqlUpdate("insert into event_interest (event_id, interest_id, last_updated) " +
            "values (:eventId, :interestId, :lastUpdated)")
    void addEventInterest(@Bind("eventId") Long eventId, @Bind("interestId") Long interestId, @Bind("lastUpdated") Timestamp lastUpdated);


    @SqlQuery("select distinct ei.interest_id from event_interest ei " +
            "inner join user_wish_list uwl on uwl.event_id = ei.event_id " +
            "left join user_interest ui on ei.interest_id = ui.interest_id " +
            "where uwl.user_id = :userId and uwl.event_id = :eventId and ui.interest_id is null")
    List<Long> findNewUserInterests(@Bind("userId") Long userId, @Bind("eventId") Long eventId);

    // only for users with no wishlist (events ordered by total count of interests)
    @RegisterMapper(EventMapper.class)
    @SqlQuery("select e.id, e.name, e.description, org.name as organization_name, e.contact, e.email, e.application_url, e.location, " +
            "e.zip_code, e.attendance, e.size, e.length, e.time " +
            "from user_interest ui " +
            "inner join event_interest ei on ui.interest_id = ei.interest_id " +
            "inner join event e on e.id = ei.event_id " +
            "inner join organization org on org.id = e.organization_id " +
            "where ui.user_id = :userId and e.id in (<eventIds>) " +
            "group by e.id, e.name, e.description, org.name, e.contact, e.application_url, e.location, e.zip_code, e.email, e.time, e.size, e.length " +
            "order by count(ei.interest_id) desc limit 50")
    List<EventDto> getRelevantEventsForUser(@Bind("userId") Long userId, @BindIn("eventIds") List<Long> eventIds);


    @SqlQuery("select event_id, interest_id from event_interest where event_id in (<eventIds>)")
    List<EventInterest> getByEventIds(@BindIn("eventIds") List<Long> eventIds);

    // for users with wishlist (events ordered by sum of interest weights)
    @RegisterMapper(EventMapper.class)
    @SqlQuery("select e.id, e.name, e.description, org.name as organization_name, e.contact, e.email, e.application_url, e.location, " +
            "e.zip_code, e.attendance, e.size, e.length, e.time " +
            "from user_interest ui " +
            "inner join event_interest ei on ui.interest_id = ei.interest_id " +
            "inner join event e on e.id = ei.event_id " +
            "inner join organization org on org.id = e.organization_id " +
            "where ui.user_id = :userId and e.id in (<eventIds>) " +
            "group by e.id, e.name, e.description, org.name, e.contact, e.application_url, e.location, e.zip_code, e.email, e.time, e.size, e.length " +
            "order by sum(ui.weight) desc limit 50")
    List<EventDto> getRelevantEventsForUserWeighted(@Bind("userId") Long userId, @BindIn("eventIds") List<Long> eventIds);
}
