package locations;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LocationsService {

    public List<Location> getLocations(){
        Location l1 = new Location(1L,"Budapest",47.497913, 19.040236);
        Location l2 = new Location(2L, "Sydney", -33.870453, 151.208755);

        return Arrays.asList(l1,l2);
    }
}
