package locations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LocationsIT {
    @Autowired
    LocationsController locationsController;

    @Test
    void getLocations(){
        String message = locationsController.getLocations();

        assertThat(message).startsWith("Kedvenc helyek");
        assertThat(message).contains("Budapest");
        assertThat(message).contains("Sydney");
    }
}
