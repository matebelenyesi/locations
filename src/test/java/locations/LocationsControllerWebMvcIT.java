package locations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(controllers= LocationsController.class)
public class LocationsControllerWebMvcIT {

    @MockBean
    LocationsService locationsService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testListLocations() throws Exception{
        when(locationsService.getLocations(any()))
                .thenReturn(Arrays.asList(
                        new LocationDto(1L, "Dummy", 1.0, 2.0),
                        new LocationDto(2L, "Test", 1.1, 2.1)
                ));

         mockMvc.perform(get("/api/locations")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name" , equalTo("Dummy")))
                 .andExpect(jsonPath("$[0].lat" , equalTo(1.0)))
                 .andExpect(jsonPath("$[1].lon" , equalTo(2.1)));


    }

    //TODO: More tests...
}
