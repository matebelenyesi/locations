package locations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocationsServiceTest {

    @Mock
    LocationMapper locationsMapper;

    @InjectMocks
    LocationsService locationsService;

    @Test
    void getLocations() {

        when(locationsMapper.toDto(any(List.class))).thenAnswer(new Answer<List<LocationDto>>() {
            @Override
            public List<LocationDto> answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                List<Location> locations = (List<Location>) args[0];
                List<LocationDto> result = new ArrayList<>();

                for(Location location : locations){
                    result.add(new LocationDto(location.getId(), location.getName(), location.getLat(), location.getLon()));
                }
                return result;
            }
        });

        List<LocationDto> locations = locationsService.getLocations(Optional.empty());

        assertEquals(2, locations.size());
        assertEquals("Budapest", locations.get(0).getName());
        assertEquals("Sydney", locations.get(1).getName());
    }
}
