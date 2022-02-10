package locations;

public class Location {

    private Long id;
    private String name;
    private double lat;
    private double lon;

    public Location(Long id, String name, double lat, double lon){
        this.id = id;
        this.name= name;
        this.lat=lat;
        this.lon = lon;
    }


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(final double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(final double lon) {
        this.lon = lon;
    }

    @Override
    public String toString(){
        return String.format("id: %s, name: %s, lat: %s, lon: %s", id,name,lat,lon);
    }
}
