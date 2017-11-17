package dao;

import mapper.EventMapper;
import model.Dto.EventDto;
import model.Event;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.sql.Timestamp;
import java.util.List;

public interface UserWishListDAO {
    @SqlUpdate("insert into user_wish_list (user_id, event_id, status, date_created, last_updated) " +
            "values (:userId, :eventId, :status, :dateCreated, :lastUpdated)")
    void addEventToWishList(@Bind("userId") Long userId, @Bind("eventId") Long eventId, @Bind("status") String status,
                            @Bind("dateCreated") Timestamp dateCreated, @Bind("lastUpdated") Timestamp lastUpdated);

    @SqlUpdate("update user_wish_list set status = :status, last_updated = :lastUpdated " +
            "where user_id = :userId and event_id = :eventId")
    void updateEventInWishList(@Bind("userId") Long userId, @Bind("eventId") Long eventId, @Bind("status") String status,
                               @Bind("lastUpdated") Timestamp lastUpdated);

    @SqlQuery("select event_id from user_wish_list where user_id = :userId")
    List<Long> getEventIdsByUserId(@Bind("userId") Long userId);

    @RegisterMapper(EventMapper.class)
    @SqlQuery("select e.id, e.name, e.description, org.name as organization_name, e.contact, e.email, e.application_url, e.location, " +
            "e.zip_code, e.attendance, e.size, e.length, e.time, uwl.status, e.image_url " +
            "from user_wish_list uwl " +
            "inner join event e on uwl.event_id = e.id " +
            "inner join organization org on org.id = e.organization_id " +
            "where user_id = :userId")
    List<EventDto> getEventsByUserId(@Bind("userId") Long userId);
}

