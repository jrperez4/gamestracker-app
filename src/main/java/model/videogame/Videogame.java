package model.videogame;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Videogame {

    public static final String JSON_RESULTS_PROPERTY_NAME = "results";
    private String slug;

    private String name;

    private int playtime;

    private List<Platform> platforms;

    private List<Store> stores;

    private String released;

    private boolean tba;

    private String background_image;

    private double rating;

    private double rating_top;

    private List<Rating> ratings;

    // Constructor
    public Videogame() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaytime() {
        return playtime;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public boolean isTba() {
        return tba;
    }

    public void setTba(boolean tba) {
        this.tba = tba;
    }

    public String getBackground_image() {return background_image;}

    public void setBackground_image(String background_image) {this.background_image = background_image;}

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating_top() {return rating_top;}

    public void setRating_top(double rating_top) {this.rating_top = rating_top;}

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
