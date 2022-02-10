package locations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocationsControllerTest {
    @Mock
    LocationsService locationsService;

    @InjectMocks
    LocationsController locationsController;

    @Test
    void getLocations() {

        Location mockLocation1 = new Location(1L,"Test",1, 1);
        Location mockLocation2 = new Location(2L, "Dummy", 2, 2);

        when(locationsService.getLocations()).thenReturn(Arrays.asList(mockLocation1,mockLocation2));


        String message = locationsController.getLocations();

        assertThat(message).startsWith("Kedvenc helyek");
        assertThat(message).contains("Test");
        assertThat(message).contains("Dummy");
    }
}
