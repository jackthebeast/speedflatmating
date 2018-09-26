package jacopo.com.speedflatmating.venuelist.view;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jacopo.com.speedflatmating.R;
import jacopo.com.speedflatmating.global.ApplicationConstants;
import jacopo.com.speedflatmating.venuelist.VenueListContract;
import jacopo.com.speedflatmating.venuelist.data.datasource.LocalVenuesDataSource;
import jacopo.com.speedflatmating.venuelist.data.repository.VenuesRepositoryImpl;
import jacopo.com.speedflatmating.venuelist.model.Venue;
import jacopo.com.speedflatmating.venuelist.presenter.MeetingsPresenter;

import static android.support.v4.content.PermissionChecker.checkSelfPermission;

public abstract class MeetingsFragment extends Fragment implements VenueListContract.View {

    protected static MeetingsFragment instance;
    protected View view;
    protected VenuesAdapter adapter;
    protected MeetingsPresenter presenter;

    @BindView(R.id.venue_list)
    RecyclerView venueList;

    private Intent callIntent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meetings, container, false);
        ButterKnife.bind(this, view);
        presenter = new MeetingsPresenter(this, VenuesRepositoryImpl.getInstance(LocalVenuesDataSource.getInstance()));
        initList();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadItems();
    }

    private void initList() {
        adapter = new VenuesAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        venueList.setLayoutManager(layoutManager);
        venueList.setAdapter(adapter);
    }

    @Override
    public void showItems(List<Venue> items) {
        adapter.setList(items);
    }

    @Override
    public void onVenueClick(Venue venue) {
        String uri = ApplicationConstants.PHONE_CALL_INTENT_PREFIX + ApplicationConstants.PHONE_CALL_NUMBER;
        callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(uri));
        if (hasPhonePermission()) {
            makePhoneCall();
        } else {
            tryRequestPhonePermission();
        }
    }

    private void makePhoneCall() {
        if (callIntent != null) {
            startActivity(callIntent);
            callIntent = null;
        }
    }

    private void tryRequestPhonePermission() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
            builder.setTitle(getString(R.string.permission_title))
                    .setMessage(getString(R.string.permission_message))
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            requestPhonePermission();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else {
            requestPhonePermission();
        }
    }

    private void requestPhonePermission(){
        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                ApplicationConstants.PHONE_CALL_PERMISSION_REQUEST_CODE);
    }

    private boolean hasPhonePermission() {
        if (checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ApplicationConstants.PHONE_CALL_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    makePhoneCall();
                }
            }
        }
    }

}
