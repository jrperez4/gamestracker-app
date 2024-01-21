package app.springboot.gamestracker.service.videogame;

import model.videogame.Videogame;
import model.videogame.VideogameDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import util.ServiceUtils;
import java.util.List;
import java.util.Optional;


@Service
public class VideogameServiceImpl implements VideogameService{

    private final String apiKey;
    private final String apiEndpoint;
    private final RestTemplate restTemplate;

    public VideogameServiceImpl(
            @Value("${rawg.api.key}") String apiKey,
            @Value("${rawg.api.endpoint}") String apiEndpoint,
            RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.apiEndpoint = apiEndpoint;
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Videogame> bestRatedVideogames() {
        String urlWithParams = apiEndpoint + "?key=" + apiKey + "&metacritic=96,100";
        return ServiceUtils.performGetRequestAndMapToList(urlWithParams, Videogame.JSON_RESULTS_PROPERTY_NAME, restTemplate, Videogame.class);
    }

    @Override
    public Optional<VideogameDetails> getGameDetails(String slug) {
        String urlWithParams = apiEndpoint + "/" + slug + "?key=" + apiKey;
        ResponseEntity<VideogameDetails> response = restTemplate.getForEntity(urlWithParams, VideogameDetails.class);
        return Optional.ofNullable(response.getBody());
    }
}
