package jacopo.com.speedflatmating.venuelist.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jacopo.com.speedflatmating.R;
import jacopo.com.speedflatmating.venuelist.model.Venue;

public class VenuesAdapter extends RecyclerView.Adapter<VenuesAdapter.VenueViewHolder> {
    private List<Venue> list;

    public static class VenueViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.venue_item_photo)
        ImageView photo;

        @BindView(R.id.venue_item_price)
        TextView price;

        @BindView(R.id.venue_item_venue)
        TextView venue;

        @BindView(R.id.venue_item_location)
        TextView location;

        @BindView(R.id.venue_item_day)
        TextView day;

        @BindView(R.id.venue_item_time)
        TextView time;


        public VenueViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    @Override
    public void onBindViewHolder(VenueViewHolder holder, int position){
        Venue venue = list.get(position);
        holder.location.setText(venue.getLocation());
        holder.price.setText(venue.getCost());
        holder.venue.setText(venue.getVenue());
        holder.day.setText(venue.getFormattedStartDate());
        holder.time.setText(venue.getFormattedTimeSpan());
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
