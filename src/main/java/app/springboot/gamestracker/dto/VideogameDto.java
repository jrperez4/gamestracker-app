package app.springboot.gamestracker.dto;

import java.util.List;

public class VideogameDto {
    private String name;
    private List<String> platforms; // Pueden ser solo los nombres de las plataformas
    private List<String> stores; // Pueden ser solo los nombres de las tiendas
    private String released;
    private double rating;

    // Otros campos y métodos getter y setter

    // Constructor
    public VideogameDto() {
    }
}
