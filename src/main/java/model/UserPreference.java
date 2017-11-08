package model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

public class UserPreference implements Serializable{

    private Long id;
    private Long userId;
    private Integer maxDistance; // max distance in miles from origin
    private Integer maxEventLength; // event length in minutes
    private Time minHour;
    private Time maxHour;
    private String eventType;
    private Integer impactIdx;
    private Integer eventSize;
    private Timestamp lastUpdated;

    public UserPreference(Long userId, Integer maxDistance, Integer maxEventLength, Time minHour, Time maxHour, String eventType, Integer impactIdx, Integer eventSize) {
        this.userId = userId;
        this.maxDistance = maxDistance;
        this.maxEventLength = maxEventLength;
        this.minHour = minHour;
        this.maxHour = maxHour;
        this.eventType = eventType;
        this.impactIdx = impactIdx;
        this.eventSize = eventSize;
    }

    public UserPreference(Long userId, Integer maxDistance, Integer maxEventLength, Time minHour, Time maxHour) {
        this.userId = userId;
        this.maxDistance = maxDistance;
        this.maxEventLength = maxEventLength;
        this.minHour = minHour;
        this.maxHour = maxHour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Integer getMaxEventLength() {
        return maxEventLength;
    }

    public void setMaxEventLength(Integer maxEventLength) {
        this.maxEventLength = maxEventLength;
    }

    public Time getMinHour() {
        return minHour;
    }

    public void setMinHour(Time minHour) {
        this.minHour = minHour;
    }

    public Time getMaxHour() {
        return maxHour;
    }

    public void setMaxHour(Time maxHour) {
        this.maxHour = maxHour;
    }


    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getImpactIdx() {
        return impactIdx;
    }

    public void setImpactIdx(Integer impactIdx) {
        this.impactIdx = impactIdx;
    }

    public Integer getEventSize() {
        return eventSize;
    }

    public void setEventSize(Integer eventSize) {
        this.eventSize = eventSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPreference that = (UserPreference) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (maxDistance != null ? !maxDistance.equals(that.maxDistance) : that.maxDistance != null) return false;
        if (maxEventLength != null ? !maxEventLength.equals(that.maxEventLength) : that.maxEventLength != null)
            return false;
        if (minHour != null ? !minHour.equals(that.minHour) : that.minHour != null) return false;
        if (maxHour != null ? !maxHour.equals(that.maxHour) : that.maxHour != null) return false;
        if (eventType != null ? !eventType.equals(that.eventType) : that.eventType != null) return false;
        if (impactIdx != null ? !impactIdx.equals(that.impactIdx) : that.impactIdx != null) return false;
        if (eventSize != null ? !eventSize.equals(that.eventSize) : that.eventSize != null) return false;
        return lastUpdated != null ? lastUpdated.equals(that.lastUpdated) : that.lastUpdated == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (maxDistance != null ? maxDistance.hashCode() : 0);
        result = 31 * result + (maxEventLength != null ? maxEventLength.hashCode() : 0);
        result = 31 * result + (minHour != null ? minHour.hashCode() : 0);
        result = 31 * result + (maxHour != null ? maxHour.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (impactIdx != null ? impactIdx.hashCode() : 0);
        result = 31 * result + (eventSize != null ? eventSize.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        return result;
    }
}
