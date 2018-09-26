package jacopo.com.speedflatmating.venuelist.data.repository;


import java.util.List;

import jacopo.com.speedflatmating.global.data.OperationCallback;
import jacopo.com.speedflatmating.venuelist.model.Venue;

public interface VenuesRepository {
    void getUpcomingMeetings (final OperationCallback<List<Venue>> callback);

    void getPastMeetings (final OperationCallback<List<Venue>> callback) ;
}
