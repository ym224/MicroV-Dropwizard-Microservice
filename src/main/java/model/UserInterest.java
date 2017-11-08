package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class UserInterest implements Serializable {

    private Long id;
    private Long userId;
    private Long interestId;
    private BigDecimal weight;
    private Timestamp lastUpdated;

    public UserInterest(Long userId, Long interestId, BigDecimal weight, Timestamp lastUpdated) {
        this.userId = userId;
        this.interestId = interestId;
        this.weight = weight;
        this.lastUpdated = lastUpdated;
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

    public Long getInterestId() {
        return interestId;
    }

    public void setInterestId(Long interestId) {
        this.interestId = interestId;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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

        UserInterest that = (UserInterest) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (interestId != null ? !interestId.equals(that.interestId) : that.interestId != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        return lastUpdated != null ? lastUpdated.equals(that.lastUpdated) : that.lastUpdated == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (interestId != null ? interestId.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        return result;
    }
}
