package jacopo.com.speedflatmating.venuelist.data.repository;


import java.util.List;

import jacopo.com.speedflatmating.global.data.OperationCallback;
import jacopo.com.speedflatmating.venuelist.data.datasource.LocalVenuesDataSource;
import jacopo.com.speedflatmating.venuelist.model.Venue;

public class VenuesRepositoryImpl implements VenuesRepository{

    private static VenuesRepositoryImpl instance;

    private LocalVenuesDataSource localDataSource;

    public static VenuesRepositoryImpl getInstance(LocalVenuesDataSource localDataSource) {
        return instance == null ? new VenuesRepositoryImpl(localDataSource) : instance;
    }

    public VenuesRepositoryImpl(LocalVenuesDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public void getUpcomingMeetings (final OperationCallback<List<Venue>> callback) {
        localDataSource.fetchUpcomingMeetings(new OperationCallback<List<Venue>>() {
            @Override
            public void onSuccess(List<Venue> response) {
                callback.onSuccess(response);
            }
        });
    }

    @Override
    public void getPastMeetings (final OperationCallback<List<Venue>> callback) {
        localDataSource.fetchPastMeetings(new OperationCallback<List<Venue>>() {
            @Override
            public void onSuccess(List<Venue> response) {
                callback.onSuccess(response);
            }
        });
    }


}
