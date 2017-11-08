package mapper;

import model.Dto.EventDto;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapperZipCode implements ResultSetMapper<EventDto> {

    @Override
    public EventDto map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
        return new EventDto(rs.getLong(1), rs.getString(2));
    }
}
