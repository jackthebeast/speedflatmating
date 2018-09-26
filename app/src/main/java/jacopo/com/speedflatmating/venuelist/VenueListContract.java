package jacopo.com.speedflatmating.venuelist;


import java.util.List;

import jacopo.com.speedflatmating.venuelist.model.Venue;

public abstract class VenueListContract {

    public interface View {
        void showItems(List<Venue> items);

        void onVenueClick(Venue venue);
    }

    public interface Presenter {
        void loadItems();
    }
}
