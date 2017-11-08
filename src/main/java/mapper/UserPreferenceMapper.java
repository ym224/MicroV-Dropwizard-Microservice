package mapper;


import model.Event;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserPreferenceMapper implements ResultSetMapper<Map>{
    @Override
    public Map map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(rs.getString(1), rs.getInt(2));
        return map;

    }
}
