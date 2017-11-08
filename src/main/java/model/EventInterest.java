package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class EventInterest implements Serializable {

    private Long id;
    private Long eventId;
    private Long interestId;
    private Timestamp lastUpdated;

    public EventInterest(Long eventId, Long interestId) {
        this.eventId = eventId;
        this.interestId = interestId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getInterestId() {
        return interestId;
    }

    public void setInterestId(Long interestId) {
        this.interestId = interestId;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventInterest that = (EventInterest) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (interestId != null ? !interestId.equals(that.interestId) : that.interestId != null) return false;
        return lastUpdated != null ? lastUpdated.equals(that.lastUpdated) : that.lastUpdated == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (interestId != null ? interestId.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        return result;
    }
}
