package app.springboot.gamestracker.service.videogame;

import model.videogame.Videogame;
import model.videogame.VideogameDetails;

import java.util.List;
import java.util.Optional;

public interface VideogameService {

    List<Videogame> bestRatedVideogames();

    Optional<VideogameDetails> getGameDetails(String slug);

}

