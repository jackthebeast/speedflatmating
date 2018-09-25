package jacopo.com.speedflatmating.venuelist.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jacopo.com.speedflatmating.R;
import jacopo.com.speedflatmating.model.Venue;

public class VenuesAdapter extends RecyclerView.Adapter<VenuesAdapter.VenueViewHolder> {
    private List<Venue> list;

    public VenuesAdapter () {
        list = new ArrayList<>();
    }

    public static class VenueViewHolder extends RecyclerView.ViewHolder{

        public VenueViewHolder(View view){
            super(view);
        }

    }

    @Override
    public void onBindViewHolder(VenueViewHolder holder, int position){
        Venue venue = list.get(position);
    }

    @Override
    public VenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_venue, parent, false);

        return new VenueViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Venue> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
