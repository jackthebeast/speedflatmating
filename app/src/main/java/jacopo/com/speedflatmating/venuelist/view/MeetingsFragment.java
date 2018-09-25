package jacopo.com.speedflatmating.venuelist.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jacopo.com.speedflatmating.R;

public abstract class MeetingsFragment extends Fragment {

    protected static MeetingsFragment instance;
    protected View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meetings, container, false);
        return view;
    }
}
