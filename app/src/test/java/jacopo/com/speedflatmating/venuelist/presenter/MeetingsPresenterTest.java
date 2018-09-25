package jacopo.com.speedflatmating.venuelist.presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import jacopo.com.speedflatmating.venuelist.data.datasource.LocalVenuesDataSource;
import jacopo.com.speedflatmating.venuelist.data.repository.VenuesRepository;
import jacopo.com.speedflatmating.venuelist.data.repository.VenuesRepositoryImpl;
import jacopo.com.speedflatmating.venuelist.view.PastFragment;
import jacopo.com.speedflatmating.venuelist.view.UpcomingFragment;
import jacopo.com.speedflatmating.model.Venue;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class MeetingsPresenterTest {

    @Mock
    UpcomingFragment upcomingFragment;

    @Mock
    PastFragment pastFragment;

    @Captor
    private ArgumentCaptor<List<Venue>> captor;

    private VenuesRepository venuesRepository;

    private MeetingsPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        venuesRepository = VenuesRepositoryImpl.getInstance(LocalVenuesDataSource.getInstance());
    }

    @Test
    public void loadUpcomingItemsTest() {
        presenter = new MeetingsPresenter(upcomingFragment, venuesRepository);

        presenter.loadItems();

        verify(upcomingFragment).showItems(captor.capture());

        List<Venue> list = captor.getValue();

        Assert.assertEquals(eq(3), eq(list.size()));
    }

    @Test
    public void loadPastItemsTest() {
        presenter = new MeetingsPresenter(pastFragment, venuesRepository);

        presenter.loadItems();

        verify(pastFragment).showItems(captor.capture());

        List<Venue> list = captor.getValue();

        Assert.assertEquals(eq(2), eq(list.size()));
    }

}
