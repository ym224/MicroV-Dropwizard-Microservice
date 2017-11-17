package mapper;


import model.Dto.EventDto;
import model.Event;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class EventMapper implements ResultSetMapper<EventDto>{
    @Override
    public EventDto map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
        EventDto event = new EventDto(rs.getLong("id"), rs.getString("name"), rs.getString("description"),
                rs.getString("organization_name"), rs.getString("contact"), rs.getString("email"),
                rs.getString("application_url"), rs.getString("location"),
                rs.getString("zip_code"), rs.getInt("attendance"), rs.getInt("size"),
                rs.getInt("length"), rs.getTimestamp("time"), rs.getString("status"), rs.getString("image_url"));
        return event;
    }
}
