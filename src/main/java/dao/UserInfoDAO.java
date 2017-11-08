package dao;

import mapper.UserInfoMapper;
import model.UserInfo;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UserInfoMapper.class)
public interface UserInfoDAO {
    @SqlQuery("insert into user_info (first_name, last_name, gender, age, email, address, phone) " +
            "values (:firstName, :lastName, :gender, :age, :email, :address, :phone) returning id")
    Long addUser(@Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("gender") String gender,
                 @Bind("age") Integer age, @Bind("email") String email, @Bind("address") String address,
                @Bind("phone") String phone);

    @SqlQuery("select first_name, last_name, gender, age, email, address, phone " +
            "from user_info where id = :id")
    UserInfo findUserById(@Bind("id") long id);
}
