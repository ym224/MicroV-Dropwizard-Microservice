package model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EventIdsDto {

    @JsonProperty("eventId")
    private List<Long> eventIds;

    public EventIdsDto(){}

    public EventIdsDto(String eventId) {
        this.eventIds = eventIds;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<Long> eventIds) {
        this.eventIds = eventIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventIdsDto that = (EventIdsDto) o;

        return eventIds != null ? eventIds.equals(that.eventIds) : that.eventIds == null;
    }

    @Override
    public int hashCode() {
        return eventIds != null ? eventIds.hashCode() : 0;
    }
}
