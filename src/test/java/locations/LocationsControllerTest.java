package locations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocationsControllerTest {
    @Mock
    LocationsService locationsService;

    @InjectMocks
    LocationsController locationsController;

    @Test
    void getLocations() {

        LocationDto mockLocation1 = new LocationDto(1L,"Test",1, 1);
        LocationDto mockLocation2 = new LocationDto(2L, "Dummy", 2, 2);

        when(locationsService.getLocations(any())).thenReturn(Arrays.asList(mockLocation1,mockLocation2));


        List<LocationDto> locations = locationsController.getLocations(Optional.empty());

        assertEquals("Test", locations.get(0).getName());
        assertEquals("Dummy", locations.get(1).getName());
    }
}
