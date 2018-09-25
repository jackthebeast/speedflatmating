package jacopo.com.speedflatmating.venuelist.presenter;

import java.util.List;

import jacopo.com.speedflatmating.global.data.OperationCallback;
import jacopo.com.speedflatmating.venuelist.VenueListContract;
import jacopo.com.speedflatmating.venuelist.data.repository.VenuesRepository;
import jacopo.com.speedflatmating.venuelist.view.MeetingsFragment;
import jacopo.com.speedflatmating.model.Venue;
import jacopo.com.speedflatmating.venuelist.view.PastFragment;
import jacopo.com.speedflatmating.venuelist.view.UpcomingFragment;

public class MeetingsPresenter implements VenueListContract.Presenter {

    private MeetingsFragment fragment;
    private VenuesRepository repository;

    public MeetingsPresenter (MeetingsFragment fragment, VenuesRepository repository) {
        this.fragment = fragment;
        this.repository = repository;
    }

    @Override
    public void loadItems() {
        final OperationCallback<List<Venue>> callback = new OperationCallback<List<Venue>>() {
            @Override
            public void onSuccess(List<Venue> response) {
                fragment.showItems(response);
            }
        };

        if (fragment instanceof UpcomingFragment)
            repository.getUpcomingMeetings(callback);
        else if (fragment instanceof PastFragment)
            repository.getPastMeetings(callback);
    }
}
