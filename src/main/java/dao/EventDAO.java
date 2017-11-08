package dao;

import mapper.EventMapper;
import mapper.EventMapperZipCode;
import model.Dto.EventDto;
import model.Event;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.unstable.BindIn;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

//@UseStringTemplate3StatementLocator
public interface EventDAO {
    @SqlQuery("insert into event (organization_id, name, description, contact, email, application_url, location, " +
            "zip_code, time, size, length) " +
            "values (:organizationId, :name, :description, :contact, :email, :applicationURL, :location, :zipCode, " +
            ":time, :size, :length) returning id")
    Long addEvent(@Bind("organizationId") Long organizationId, @Bind("name") String name, @Bind("description") String description,
                        @Bind("contact") String contact, @Bind("email") String email, @Bind("applicationURL") String applicationURL,
                        @Bind("location") String location, @Bind("zipCode") String zipCode, @Bind("time") Timestamp time,
                        @Bind("size") Integer size, @Bind("length") Integer length);

    @RegisterMapper(EventMapper.class)
    @SqlQuery("select e.id, e.name, e.description, org.name, e.contact, e.email, e.application_url, e.location, " +
            "e.zip_code, e.attendance, e.size, e.length, e.time from event e " +
            "inner join organization org on e.organization_id = org.id " +
            "where id in (<eventIds>)")
    List<EventDto> getEventsByIds(@BindIn("eventIds") List<Long> eventIds);

    @RegisterMapper(EventMapperZipCode.class)
    @SqlQuery("select e.id, e.zip_code from event e " +
            "cross join user_preference up " +
            "where up.user_id = :userId and (up.min_hour<=(EXTRACT(HOUR FROM(e.time)))) and up.max_event_length >= e.length")
    List<EventDto> getEventIdsAndZipCodesByTime(@Bind("userId") Long userId);
}
