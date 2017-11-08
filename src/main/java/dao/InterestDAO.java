package dao;

import mapper.InterestMapper;
import model.Interest;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(InterestMapper.class)
public interface InterestDAO {

    @SqlUpdate("insert into interest (name) " +
            "values (:name)")
    void addInterest(@Bind("name") String name);

    @SqlQuery("select id, name from interest")
    List<Interest> getAllInterests();
}
