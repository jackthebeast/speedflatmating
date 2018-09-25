package jacopo.com.speedflatmating.venuelist.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jacopo.com.speedflatmating.R;
import jacopo.com.speedflatmating.venuelist.VenueListContract;
import jacopo.com.speedflatmating.venuelist.data.datasource.LocalVenuesDataSource;
import jacopo.com.speedflatmating.venuelist.data.repository.VenuesRepositoryImpl;
import jacopo.com.speedflatmating.venuelist.presenter.MeetingsPresenter;

public abstract class MeetingsFragment extends Fragment implements VenueListContract.View {

    protected static MeetingsFragment instance;
    protected View view;
    protected VenuesAdapter adapter;
    protected MeetingsPresenter presenter;

    @BindView(R.id.venue_list)
    RecyclerView venueList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meetings, container, false);
        ButterKnife.bind(this, view);
        presenter = new MeetingsPresenter(this, VenuesRepositoryImpl.getInstance(LocalVenuesDataSource.getInstance()));
        return view;
    }

    @Override
    public void showItems(List<jacopo.com.speedflatmating.model.Venue> items) {
        adapter = new VenuesAdapter();
        adapter.setList(items);
    }
}
