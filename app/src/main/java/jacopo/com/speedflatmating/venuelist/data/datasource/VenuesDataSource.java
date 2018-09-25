package jacopo.com.speedflatmating.venuelist.data.datasource;

import java.util.List;

import jacopo.com.speedflatmating.global.data.OperationCallback;
import jacopo.com.speedflatmating.model.Venue;

public interface VenuesDataSource {

    void fetchUpcomingMeetings(OperationCallback<List<Venue>> callback);

    void fetchPastMeetings(OperationCallback<List<Venue>> callback);
}
