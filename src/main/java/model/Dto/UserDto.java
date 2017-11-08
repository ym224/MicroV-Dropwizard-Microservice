package model.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable{

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String address; //zipcode for now
    private String email;
    private String phone;
    private Integer maxDistance; // max distance in miles from origin
    private Integer maxEventLength; // event length in minutes
    private Integer minHour;
    private Integer maxHour;
    private String volType;
    private String eventType;
    private Integer impactIdx;
    private Integer eventSize;
    private List<Long> interestIds;

    public UserDto(){}

    public UserDto(String firstName, String lastName, Integer age, String gender, String address, String email, String phone,
                   Integer maxDistance, Integer maxEventLength, Integer minHour, Integer maxHour,
                   String volType, String eventType, Integer impactIdx, Integer eventSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.maxDistance = maxDistance;
        this.maxEventLength = maxEventLength;
        this.minHour = minHour;
        this.maxHour = maxHour;
        this.volType = volType;
        this.eventType = eventType;
        this.impactIdx = impactIdx;
        this.eventSize = eventSize;
        this.interestIds = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getMinHour() {
        return minHour;
    }

    public void setMinHour(Integer minHour) {
        this.minHour = minHour;
    }

    public Integer getMaxHour() {
        return maxHour;
    }

    public void setMaxHour(Integer maxHour) {
        this.maxHour = maxHour;
    }

    public String getVolType() {
        return volType;
    }

    public void setVolType(String volType) {
        this.volType = volType;
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

    public List<Long> getInterestIds() {
        return interestIds;
    }

    public void setInterestIds(List<Long> interestIds) {
        this.interestIds = interestIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (id != null ? !id.equals(userDto.id) : userDto.id != null) return false;
        if (firstName != null ? !firstName.equals(userDto.firstName) : userDto.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userDto.lastName) : userDto.lastName != null) return false;
        if (age != null ? !age.equals(userDto.age) : userDto.age != null) return false;
        if (gender != null ? !gender.equals(userDto.gender) : userDto.gender != null) return false;
        if (address != null ? !address.equals(userDto.address) : userDto.address != null) return false;
        if (email != null ? !email.equals(userDto.email) : userDto.email != null) return false;
        if (phone != null ? !phone.equals(userDto.phone) : userDto.phone != null) return false;
        if (maxDistance != null ? !maxDistance.equals(userDto.maxDistance) : userDto.maxDistance != null) return false;
        if (maxEventLength != null ? !maxEventLength.equals(userDto.maxEventLength) : userDto.maxEventLength != null)
            return false;
        if (minHour != null ? !minHour.equals(userDto.minHour) : userDto.minHour != null) return false;
        if (maxHour != null ? !maxHour.equals(userDto.maxHour) : userDto.maxHour != null) return false;
        if (volType != null ? !volType.equals(userDto.volType) : userDto.volType != null) return false;
        if (eventType != null ? !eventType.equals(userDto.eventType) : userDto.eventType != null) return false;
        if (impactIdx != null ? !impactIdx.equals(userDto.impactIdx) : userDto.impactIdx != null) return false;
        return eventSize != null ? eventSize.equals(userDto.eventSize) : userDto.eventSize == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (maxDistance != null ? maxDistance.hashCode() : 0);
        result = 31 * result + (maxEventLength != null ? maxEventLength.hashCode() : 0);
        result = 31 * result + (minHour != null ? minHour.hashCode() : 0);
        result = 31 * result + (maxHour != null ? maxHour.hashCode() : 0);
        result = 31 * result + (volType != null ? volType.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (impactIdx != null ? impactIdx.hashCode() : 0);
        result = 31 * result + (eventSize != null ? eventSize.hashCode() : 0);
        return result;
    }
}
