package locations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationsControllerRestTemplateIT {

    @Autowired
    TestRestTemplate template;

    @Autowired
    LocationsService locationsService;

    @Test
    void testListLocations(){

        locationsService.deleteAllLocations();

        LocationDto locationDto =  template.postForObject("/api/locations", new CreateLocationCommand("New",1L,2L), LocationDto.class);

        assertEquals("New", locationDto.getName());

        template.postForObject("/api/locations", new CreateLocationCommand("Newer",3L,4L), LocationDto.class);

        List<LocationDto> employees =

                template.exchange("/api/locations", HttpMethod.GET, null, new ParameterizedTypeReference<List<LocationDto>>() {
                }).getBody();

        assertThat(employees).extracting(LocationDto::getName).containsExactly("New", "Newer");
    }

    //TODO: More tests...
}