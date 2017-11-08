package dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface OrganizationDAO {

    @SqlUpdate("insert into organization (name, address, email, website) " +
            "values (:name, :address, :email, :website)")
    int addOrganization(@Bind("name") String name, @Bind("address") String address, @Bind("email") String email,
                @Bind("website") String website);

}
