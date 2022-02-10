package locations;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationsController {

    private LocationsService locationsService;

    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @GetMapping
    public List<LocationDto> getLocations(@RequestParam Optional<String> prefix){
        return locationsService.getLocations(prefix);
    }

    @GetMapping(value = "/{id}")
    public LocationDto findEmployeeById(@PathVariable("id") long id){
        return locationsService.findLocationById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDto createLocation(@RequestBody CreateLocationCommand command) {
        return locationsService.createLocation(command);
    }

    @PutMapping("/{id}")
    public LocationDto updateEmployee(@PathVariable("id") long id, @RequestBody UpdateLocationCommand command){
        return locationsService.updateLocation(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") long id){
        locationsService.deleteLocation(id);
    }

    /*private String printLocations(List<LocationDto> locations){
        String locationsAsString = "Kedvenc helyek: <br>";

        for(LocationDto location : locations){
            locationsAsString += (location.toString() + "<br>");
        }

        return locationsAsString;
    }

    private String printOneLocation(LocationDto location){
        return location.toString();
    }*/

}
