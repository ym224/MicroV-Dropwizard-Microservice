package mapper;

import model.UserInfo;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoMapper implements ResultSetMapper<UserInfo> {
    @Override
    public UserInfo map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
        UserInfo userInfo = new UserInfo(rs.getString("first_name"), rs.getString("last_name"),
                rs.getString("gender"), rs.getInt("age"),
                rs.getString("address"), rs.getString("email"),
                rs.getString("phone"), rs.getString("zip_code"));

        return userInfo;
    }
}
