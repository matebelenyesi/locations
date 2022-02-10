package locations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LocationsIT {
    @Autowired
    LocationsController locationsController;

    @Test
    void getLocations(){
        List<LocationDto> locations = locationsController.getLocations(Optional.empty());

        assertEquals("Budapest", locations.get(0).getName());
        assertEquals("Sydney", locations.get(1).getName());
    }
}
