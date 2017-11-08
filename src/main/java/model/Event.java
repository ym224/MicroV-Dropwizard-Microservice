package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Event implements Serializable{

    private Long id;
    private String name;
    private String description;
    private Long organizationId;
    private String contactName;
    private String email;
    private String applicationURL;
    private String location;
    private String zipCode;
    private Timestamp time;
    private Integer size;
    private Integer length; //length in minutes

    public Event(){}

    public Event(Long id, String name, String description, Long organizationId, String contactName, String email,
                 String applicationURL, String location, String zipCode, Integer size, Integer length, Timestamp time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.organizationId = organizationId;
        this.contactName = contactName;
        this.email = email;
        this.applicationURL = applicationURL;
        this.location = location;
        this.zipCode = zipCode;
        this.size = size;
        this.time = time;
        this.length = length;
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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (organizationId != null ? !organizationId.equals(event.organizationId) : event.organizationId != null) return false;
        if (contactName != null ? !contactName.equals(event.contactName) : event.contactName != null) return false;
        if (email != null ? !email.equals(event.email) : event.email != null) return false;
        if (applicationURL != null ? !applicationURL.equals(event.applicationURL) : event.applicationURL != null)
            return false;
        if (location != null ? !location.equals(event.location) : event.location != null) return false;
        if (zipCode != null ? !zipCode.equals(event.zipCode) : event.zipCode != null) return false;
        if (time != null ? !time.equals(event.time) : event.time != null) return false;
        if (size != null ? !size.equals(event.size) : event.size != null) return false;
        return length != null ? length.equals(event.length) : event.length == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (applicationURL != null ? applicationURL.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        return result;
    }
}
