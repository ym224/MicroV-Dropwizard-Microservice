package mapper;

import model.EventInterest;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventInterestMapper implements ResultSetMapper<EventInterest> {
    @Override
    public EventInterest map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
        EventInterest eventInterest = new EventInterest(rs.getLong("event_id"),
                rs.getLong("interest_id"));

        return eventInterest;
    }
}
