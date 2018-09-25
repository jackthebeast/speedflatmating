package jacopo.com.speedflatmating.venuelist.data.datasource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jacopo.com.speedflatmating.global.data.OperationCallback;
import jacopo.com.speedflatmating.model.Venue;

public class LocalVenuesDataSource implements VenuesDataSource{

    private static LocalVenuesDataSource instance;
    private Gson gson;

    public static LocalVenuesDataSource getInstance () {
        return instance == null ? new LocalVenuesDataSource() : instance;
    }

    public LocalVenuesDataSource(){
        gson = new GsonBuilder().setDateFormat(Venue.datePattern).create();
    }

    @Override
    public void fetchUpcomingMeetings(OperationCallback<Collection<Venue>> callback) {
        String jsonString = DummyVenuesProvider.getUpcoming();

        Venue[] array = gson.fromJson(jsonString, Venue[].class);

        List<Venue> list = Arrays.asList(array);

        callback.onSuccess(list);
    }

    @Override
    public void fetchPastMeetings(OperationCallback<Collection<Venue>> callback) {
        String jsonString = DummyVenuesProvider.getPast();

        Venue[] array = gson.fromJson(jsonString, Venue[].class);

        List<Venue> list = Arrays.asList(array);

        callback.onSuccess(list);
    }
}
