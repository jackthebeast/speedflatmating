package jacopo.com.speedflatmating.venuelist.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PastFragment extends MeetingsFragment {

    public static MeetingsFragment getInstance () {
        return instance == null ? new PastFragment() : instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

}
