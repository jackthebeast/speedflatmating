package jacopo.com.speedflatmating.venuelist.data.datasource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import jacopo.com.speedflatmating.model.Venue;

import jacopo.com.speedflatmating.global.data.OperationCallback;
import jacopo.com.speedflatmating.venuelist.data.repository.VenuesRepository;
import jacopo.com.speedflatmating.venuelist.data.repository.VenuesRepositoryImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

public class VenuesRepositoryImplTest {

    @Captor
    private ArgumentCaptor<OperationCallback<List<Venue>>> captor;

    @Mock
    private LocalVenuesDataSource dataSource;

    private VenuesRepository repository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        repository = VenuesRepositoryImpl.getInstance(dataSource);
    }

    @Test
    public void getUpcomingMeetingsTest(){
        OperationCallback<List<Venue>> callback = mock(OperationCallback.class);
        repository.getUpcomingMeetings(callback);

        verify(dataSource).fetchUpcomingMeetings(captor.capture());

        captor.getValue().onSuccess(ArgumentMatchers.<Venue>anyList());

        verify(callback).onSuccess(ArgumentMatchers.<Venue>anyList());
    }

    @Test
    public void getPastMeetingsTest(){
        OperationCallback<List<Venue>> callback = mock(OperationCallback.class);
        repository.getPastMeetings(callback);

        verify(dataSource).fetchPastMeetings(captor.capture());

        captor.getValue().onSuccess(ArgumentMatchers.<Venue>anyList());

        verify(callback).onSuccess(ArgumentMatchers.<Venue>anyList());
    }
}
