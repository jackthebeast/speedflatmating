package jacopo.com.speedflatmating.model;

import java.util.Date;

public class Venue {

    String imageUrl;
    String location;
    String venue;
    Date startTime;
    Date endTime;
    String cost;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    //    {
//        "imageUrl": "imageUrl",
//            "location": "The Penny Farthing",
//            "venue": "Manhattan",
//            "startTime": "2018-09-01 17:00:00",
//            "endTime": "2018-09-01 22:00:00",
//            "cost": "free"
//    }

}
