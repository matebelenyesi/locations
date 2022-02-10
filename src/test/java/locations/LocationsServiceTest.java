package locations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationsServiceTest {

    @Test
    void getLocations() {
        LocationsService locationsService = new LocationsService();
        List<Location> locations = locationsService.getLocations();

        assertEquals(2, locations.size());
        assertEquals("Budapest", locations.get(0).getName());
        assertEquals("Sydney", locations.get(1).getName());
    }
}
