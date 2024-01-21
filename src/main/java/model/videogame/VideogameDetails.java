package model.videogame;


import model.Genre;

import java.util.List;

public class VideogameDetails {

    private String id;

    private String slug;

    private String name;

    private String name_original;

    private String description;

    private String metacritic;

    private String released;

    private String background_image;

    private String background_image_additional;

    private String website;

    private List<Rating> ratings;

    private List<Genre> genres;

    private List<Developer> developers;

    public VideogameDetails() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_original() {
        return name_original;
    }

    public void setName_original(String name_original) {
        this.name_original = name_original;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(String metacritic) {
        this.metacritic = metacritic;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public String getBackground_image_additional() {
        return background_image_additional;
    }

    public void setBackground_image_additional(String background_image_additional) {
        this.background_image_additional = background_image_additional;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
}
