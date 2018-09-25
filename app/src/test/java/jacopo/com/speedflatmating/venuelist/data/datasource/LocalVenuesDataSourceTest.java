package jacopo.com.speedflatmating.venuelist.data.datasource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import jacopo.com.speedflatmating.global.data.OperationCallback;
import jacopo.com.speedflatmating.model.Venue;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class LocalVenuesDataSourceTest {

    @Mock
    private OperationCallback callback;

    @Captor
    private ArgumentCaptor<List<Venue>> captor;

    private LocalVenuesDataSource dataSource;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        dataSource = LocalVenuesDataSource.getInstance();
    }

    @Test
    public void fetchUpcomingMeetingsTest(){
        dataSource.fetchUpcomingMeetings(callback);

        verify(callback).onSuccess(captor.capture());

        List<Venue> list = captor.getValue();

        Assert.assertEquals(eq(3), eq(list.size()));

        Assert.assertEquals(eq("The Penny Farthing"), eq(list.get(0).getLocation()));
    }

    @Test
    public void fetchPastMeetingsTest(){
        dataSource.fetchPastMeetings(callback);

        verify(callback).onSuccess(captor.capture());

        List<Venue> list = captor.getValue();

        Assert.assertEquals(eq(2), eq(list.size()));

        Assert.assertEquals(eq("The Dwarf"), eq(list.get(0).getLocation()));
    }
}
