package jacopo.com.speedflatmating.venuelist.view;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import jacopo.com.speedflatmating.R;

public class TabAdapter extends FragmentPagerAdapter {
    private Activity activity;

    public TabAdapter(FragmentManager fragmentManager, Activity activity) {
        super(fragmentManager);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0)
            fragment = UpcomingFragment.getInstance();
        else
            fragment = PastFragment.getInstance();
        return fragment;
    }

    @Override
    public String getPageTitle(int position){
        String title = null;
        if(position == 0)
            title = activity.getString(R.string.upcoming);
        else
            title = activity.getString(R.string.past);
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
