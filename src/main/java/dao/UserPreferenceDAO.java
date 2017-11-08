package dao;

import mapper.UserPreferenceMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface UserPreferenceDAO {
    @SqlUpdate("insert into user_preference (user_id, max_distance, max_event_length, min_hour, max_hour, event_type, " +
            "impact_idx, event_size, last_updated) " +
            "values (:userId, :maxDistance, :maxEventLength, :minHour, :maxHour, :eventType, :impactIdx, :eventSize, :lastUpdated)")
    int addUserPreference(@Bind("userId") Long userId, @Bind("maxDistance") Integer maxDistance,
                @Bind("maxEventLength") Integer maxEventLength, @Bind("minHour") Integer minHour,
                          @Bind("maxHour") Integer maxHour, @Bind("eventType") String eventType,
                          @Bind("impactIdx") Integer impactIdx, @Bind("eventSize") Integer eventSize,
                          @Bind("lastUpdated") Timestamp lastUpdated);


    @RegisterMapper(UserPreferenceMapper.class)
    @SqlQuery("select ui.zip_code, up.max_distance from user_preference up " +
            "inner join user_info ui on up.user_id = ui.id " +
            "where ui.id = :userId")
    Map<String, Integer> getPreferredRangeAndZipCode(@Bind("userId") Long userId);
}


