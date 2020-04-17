package covid.map;

public class Point {
    private Double lat;
    private Double lon;
    private String text;

    public Point() {
    }

    public Point(Double lat, Double lon, String text) {
        this.lat = lat;
        this.lon = lon;
        this.text = text;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
