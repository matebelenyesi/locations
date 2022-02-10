package locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private Long id;
    private String name;
    private double lat;
    private double lon;

    @Override
    public String toString(){
        return String.format("id: %s, name: %s, lat: %s, lon: %s", id,name,lat,lon);
    }
}
