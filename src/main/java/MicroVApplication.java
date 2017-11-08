
import dao.*;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import model.UserPreference;
import model.UserWishList;
import org.eclipse.jetty.server.session.SessionHandler;
import org.skife.jdbi.v2.DBI;
import resource.*;
import service.RecommendationService;
import service.ZipCodeDistanceService;

import javax.ws.rs.client.Client;


public class MicroVApplication extends Application<MicroVConfiguration> {
    public static void main(String[] args) throws Exception {
        new MicroVApplication().run(args);
    }

    private static void enableSessionSupport(Environment env) {
        env.servlets().setSessionHandler(new SessionHandler());
    }

    @Override
    public void initialize(Bootstrap<MicroVConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<MicroVConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(MicroVConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(MicroVConfiguration config,
                    Environment environment) {
        final Client client = new JerseyClientBuilder(environment).using(config.getJerseyClientConfiguration())
                .build(getName());

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
        final String zipCodeAPIURL = config.getZipCodeAPIURL();
        final String zipCodeAPIApplicationKey = config.getZipCodeAPIApplicationKey();
        final UserInfoDAO userInfoDAO = jdbi.onDemand(UserInfoDAO.class);
        final UserPreferenceDAO userPreferenceDAO = jdbi.onDemand(UserPreferenceDAO.class);
        final InterestDAO interestDAO = jdbi.onDemand(InterestDAO.class);
        final UserInterestDAO userInterestDAO = jdbi.onDemand(UserInterestDAO.class);
        final OrganizationDAO organizationDAO = jdbi.onDemand(OrganizationDAO.class);
        final EventDAO eventDAO = jdbi.onDemand(EventDAO.class);
        final EventInterestDAO eventInterestDAO = jdbi.onDemand(EventInterestDAO.class);
        final UserWishListDAO userWishListDAO = jdbi.onDemand(UserWishListDAO.class);

        final ZipCodeDistanceService zipCodeDistanceService =
                new ZipCodeDistanceService(zipCodeAPIURL, zipCodeAPIApplicationKey, client);
        final RecommendationService recommendationService = new RecommendationService( zipCodeDistanceService,
                eventInterestDAO, userWishListDAO, userInterestDAO, eventDAO, userPreferenceDAO);

        environment.jersey().register(new InterestResource(interestDAO));
        environment.jersey().register(new UserResource(userInfoDAO, userPreferenceDAO, userInterestDAO));
        environment.jersey().register(new OrganizationResource(organizationDAO));
        environment.jersey().register(new EventResource(eventDAO, eventInterestDAO, interestDAO));
        environment.jersey().register(new UserEventResource(userWishListDAO, eventInterestDAO, userInterestDAO));
        environment.jersey().register(new RecommendEventResource(recommendationService));
    }
}
