package dao;

import mapper.UserInfoMapper;
import model.UserInfo;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.math.BigDecimal;
import java.sql.Timestamp;

@RegisterMapper(UserInfoMapper.class)
public interface UserInterestDAO {
    @SqlUpdate("insert into user_interest (user_id, interest_id, weight, last_updated) " +
            "values (:userId, :interestId, :weight, :lastUpdated)")
    int addUserInterest(@Bind("userId") Long userId, @Bind("interestId") Long interestId, @Bind("weight") BigDecimal weight,
                        @Bind("lastUpdated") Timestamp lastUpdated);


    @SqlUpdate("update user_interest set weight = :weight where user_id = :userId and interest_id = :interestId")
    void updateInterestWeights(@Bind("userId") Long userId, @Bind("interestId") Long interestId,
                               @Bind("weight") BigDecimal weight);
}
