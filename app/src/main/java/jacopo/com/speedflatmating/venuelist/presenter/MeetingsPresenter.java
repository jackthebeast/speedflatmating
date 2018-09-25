package jacopo.com.speedflatmating.venuelist.presenter;

import jacopo.com.speedflatmating.venuelist.VenueListContract;
import jacopo.com.speedflatmating.venuelist.data.repository.VenuesRepository;
import jacopo.com.speedflatmating.venuelist.view.MeetingsFragment;

public class MeetingsPresenter implements VenueListContract.Presenter {

    private MeetingsFragment fragment;
    private VenuesRepository repository;

    public MeetingsPresenter (MeetingsFragment fragment, VenuesRepository repository) {
        this.fragment = fragment;
        this.repository = repository;
    }

    @Override
    public void loadItems() {
        //TODO
    }
}
