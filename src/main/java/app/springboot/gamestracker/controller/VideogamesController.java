package app.springboot.gamestracker.controller;

import app.springboot.gamestracker.service.videogame.VideogameServiceImpl;
import model.videogame.Videogame;
import model.videogame.VideogameDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class VideogamesController {

    @Autowired
    private VideogameServiceImpl videogamesService;

    @GetMapping("/catalog/videogames")
    public String showVideogamesPage(Model model, Principal principal) {

        // Lógica para obtener datos de la API de videojuegos
        List<Videogame> videogames = videogamesService.bestRatedVideogames();

        // Agregar datos al modelo para que se muestren en la plantilla
        model.addAttribute("videogames", videogames);

        return "videogames-home"; // Nombre de la plantilla Thymeleaf (videogames.html)
    }

    @GetMapping("/game-details/{slug}")
    public ResponseEntity<VideogameDetails> getGameDetails(@PathVariable String slug) {
        Optional<VideogameDetails> gameDetailsResponse = videogamesService.getGameDetails(slug);
        return gameDetailsResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
