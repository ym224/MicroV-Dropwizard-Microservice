package model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EventDto  {

    private Long id;
    private String name;
    private String description;
    private String organizationName;
    private String contactName;
    private String email;
    private String applicationURL;
    private String location;
    private String zipCode;
    private Timestamp time;
    private Integer attendance; // current attendance
    private Integer size; // max attendance size
    @JsonProperty("event_length")
    private Integer length; //length in minutes
    private List<String> tags;
    private String imageURL;
    private String status; // status of the event: added, applied, registered...

    public EventDto(){}

    public EventDto(Long id, String zipCode) {
        this.id = id;
        this.zipCode = zipCode;
    }

    public EventDto(Long id, String name, String description, String organizationName, String contactName, String email,
                    String applicationURL, String location, String zipCode, Integer attendance,
                    Integer size, Integer length, Timestamp time, String status, String imageURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.organizationName = organizationName;
        this.contactName = contactName;
        this.email = email;
        this.applicationURL = applicationURL;
        this.location = location;
        this.zipCode = zipCode;
        this.attendance = attendance;
        this.size = size;
        this.time = time;
        this.length = length;
        this.status = status;
        this.imageURL = imageURL;
        this.tags = new ArrayList<>();
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApplicationURL() {
        return applicationURL;
    }

    public void setApplicationURL(String applicationURL) {
        this.applicationURL = applicationURL;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventDto eventDto = (EventDto) o;

        if (id != null ? !id.equals(eventDto.id) : eventDto.id != null) return false;
        if (name != null ? !name.equals(eventDto.name) : eventDto.name != null) return false;
        if (description != null ? !description.equals(eventDto.description) : eventDto.description != null)
            return false;
        if (organizationName != null ? !organizationName.equals(eventDto.organizationName) : eventDto.organizationName != null)
            return false;
        if (contactName != null ? !contactName.equals(eventDto.contactName) : eventDto.contactName != null)
            return false;
        if (email != null ? !email.equals(eventDto.email) : eventDto.email != null) return false;
        if (applicationURL != null ? !applicationURL.equals(eventDto.applicationURL) : eventDto.applicationURL != null)
            return false;
        if (location != null ? !location.equals(eventDto.location) : eventDto.location != null) return false;
        if (zipCode != null ? !zipCode.equals(eventDto.zipCode) : eventDto.zipCode != null) return false;
        if (time != null ? !time.equals(eventDto.time) : eventDto.time != null) return false;
        if (attendance != null ? !attendance.equals(eventDto.attendance) : eventDto.attendance != null) return false;
        if (size != null ? !size.equals(eventDto.size) : eventDto.size != null) return false;
        if (length != null ? !length.equals(eventDto.length) : eventDto.length != null) return false;
        if (tags != null ? !tags.equals(eventDto.tags) : eventDto.tags != null) return false;
        if (imageURL != null ? !imageURL.equals(eventDto.imageURL) : eventDto.imageURL != null) return false;
        return status != null ? status.equals(eventDto.status) : eventDto.status == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (organizationName != null ? organizationName.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (applicationURL != null ? applicationURL.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (attendance != null ? attendance.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (imageURL != null ? imageURL.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
