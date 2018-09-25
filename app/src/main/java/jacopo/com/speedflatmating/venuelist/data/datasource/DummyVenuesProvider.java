package jacopo.com.speedflatmating.venuelist.data.datasource;

import android.support.annotation.VisibleForTesting;

public final class DummyVenuesProvider {

    @VisibleForTesting
    static String upcoming = "[{\"imageUrl\": \"penny.png\",\"location\": \"The Penny Farthing\",\"venue\": \"Manhattan\",\"startTime\": \"2018-09-28 17:00:00\",\"endTime\": \"2018-09-28 22:00:00\",\"cost\": \"free\"}," +
                                        "{\"imageUrl\": \"wework.png\",\"location\": \"WeWork, 115 Broadway\",\"venue\": \"Manhattan\",\"startTime\": \"2018-10-07 17:00:00\",\"endTime\": \"2018-10-07 22:00:00\",\"cost\": \"paid\"}," +
                                        "{\"imageUrl\": \"dwarf.png\",\"location\": \"The Dwarf\",\"venue\": \"Queens\",\"startTime\": \"2018-10-31 17:00:00\",\"endTime\": \"2018-10-31 22:00:00\",\"cost\": \"paid\"}]";

    @VisibleForTesting
    static String past = "[{\"imageUrl\": \"penny.png\",\"location\": \"The Penny Farthing\",\"venue\": \"Manhattan\",\"startTime\": \"2018-08-28 17:00:00\",\"endTime\": \"2018-08-28 22:00:00\",\"cost\": \"free\"}," +
                                        "{\"imageUrl\": \"dwarf.png\",\"location\": \"The Dwarf\",\"venue\": \"Queens\",\"startTime\": \"2018-09-24 17:00:00\",\"endTime\": \"2018-09-24 22:00:00\",\"cost\": \"paid\"}]";

    public static String getUpcoming() {
        return upcoming;
    }

    public static String getPast() {
        return past;
    }

}
