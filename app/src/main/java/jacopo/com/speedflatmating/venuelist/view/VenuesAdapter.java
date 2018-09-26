package jacopo.com.speedflatmating.venuelist.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jacopo.com.speedflatmating.R;
import jacopo.com.speedflatmating.global.ApplicationConstants;
import jacopo.com.speedflatmating.venuelist.VenueListContract;
import jacopo.com.speedflatmating.venuelist.model.Venue;

public class VenuesAdapter extends RecyclerView.Adapter<VenuesAdapter.VenueViewHolder> {
    private VenueListContract.View parentView;
    private List<Venue> list;

    public VenuesAdapter(VenueListContract.View parentView) {
        this.parentView = parentView;
    }

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
    public void onBindViewHolder(VenueViewHolder holder, final int position){
        Venue venue = list.get(position);
        Picasso.get().load(ApplicationConstants.ASSETS_FOLDER + venue.getImageUrl()).into(holder.photo);
        holder.location.setText(venue.getLocation());
        holder.price.setText(venue.getCost());
        holder.venue.setText(venue.getVenue());
        holder.day.setText(venue.getFormattedStartDate());
        holder.time.setText(venue.getFormattedTimeSpan());
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                parentView.onVenueClick(getItem(position));
            }
        });
    }

    @Override
    public VenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_venue, parent, false);

        return new VenueViewHolder(itemView);
    }

    private Venue getItem (int position) {
        return list.get(position);
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
