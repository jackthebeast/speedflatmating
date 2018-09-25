package jacopo.com.speedflatmating.venuelist.data.datasource;

import java.util.Collection;

import jacopo.com.speedflatmating.global.data.OperationCallback;
import jacopo.com.speedflatmating.model.Venue;

public interface VenuesDataSource {

    void fetchUpcomingMeetings(OperationCallback<Collection<Venue>> callback);

    void fetchPastMeetings(OperationCallback<Collection<Venue>> callback);
}
