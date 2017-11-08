package mapper;

import model.Interest;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterestMapper implements ResultSetMapper<Interest> {
@Override
public Interest map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
    Interest interest = new Interest(rs.getLong("id"), rs.getString("name"));
        return interest;
    }

}
