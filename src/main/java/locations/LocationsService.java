package locations;


import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class LocationsService {

    private AtomicLong idGenerator = new AtomicLong();

    private LocationMapper locationMapper;

    public LocationsService(LocationMapper locationMapper) {
        this.locationMapper = locationMapper;
    }

    private List<Location> locations = Collections.synchronizedList(new ArrayList<>(Arrays.asList(
            new Location(idGenerator.incrementAndGet(), "Budapest",47.497913, 19.040236),
            new Location(idGenerator.incrementAndGet(), "Sydney", -33.870453, 151.208755)
    )));

    public List<LocationDto> getLocations(Optional<String> prefix){
        List<Location> filtered =
                locations.stream()
                        .filter(l -> !prefix.isPresent() || l.getName().toLowerCase().startsWith(prefix.get().toLowerCase()))
                        .collect(Collectors.toList());
        return locationMapper.toDto(filtered);
    }


    public LocationDto findLocationById(long id) {
        return locationMapper.toDto(
                locations.stream().filter(l -> l.getId() == id).findAny()
                        .orElseThrow(() -> new LocationNotFoundException(id)));
    }

    public LocationDto createLocation(CreateLocationCommand command) {
        Location location = new Location(idGenerator.incrementAndGet(), command.getName(), command.getLat(), command.getLon());
        locations.add(location);
        return locationMapper.toDto(location);
    }

    public LocationDto updateLocation(long id, UpdateLocationCommand command) {
        Location location = locations.stream().filter(l -> l.getId() == id)
                .findFirst()
                .orElseThrow(() -> new LocationNotFoundException(id));

        location.setName(command.getName());
        location.setLat(command.getLat());
        location.setLon(command.getLon());
        return locationMapper.toDto(location);
    }

    public void deleteLocation(long id) {
        Location location = locations.stream().filter(l -> l.getId() == id)
                .findFirst()
                .orElseThrow(() -> new LocationNotFoundException(id));

        locations.remove(location);
    }

    public void deleteAllLocations(){
        idGenerator = new AtomicLong();
        locations.clear();
    }
}
