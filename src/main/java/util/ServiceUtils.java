package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

public class ServiceUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> mapJsonArray(String jsonString, String arrayPropertyName, Class<T> targetType) {
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            JsonNode arrayNode = jsonNode.get(arrayPropertyName);

            if (arrayNode != null && arrayNode.isArray()) {
                return objectMapper.readValue(arrayNode.toString(), new TypeReference<List<T>>() {});
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Return an empty list or handle the situation based on your requirements
        return Collections.emptyList();
    }

    public static <T> List<T> performGetRequestAndMapToList(String url, String results, RestTemplate restTemplate, Class<T> targetType) {
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                String responseBody = responseEntity.getBody();
                // Ajusta este método según la estructura exacta de tu JSON
                return mapJsonArray(responseBody, results, targetType);
            } else {
                // Handle non-successful response
                System.out.println("Request failed with status code: " + responseEntity.getStatusCode());
                System.out.println("Response body: " + responseEntity.getBody());
            }
        } catch (HttpClientErrorException e) {
            // Handle HTTP client errors
            System.out.println("HTTP client error: " + e.getRawStatusCode() + " - " + e.getStatusText());
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }

        // Return an empty list or handle the situation based on your requirements
        return Collections.emptyList();
    }

    private static void handleJsonProcessingException(JsonProcessingException e) {
        if (e instanceof UnrecognizedPropertyException) {
            // Handle unrecognized property exception
            UnrecognizedPropertyException ex = (UnrecognizedPropertyException) e;
            System.out.println("Unrecognized property: " + ex.getPropertyName());
        } else {
            // Handle other JSON processing exceptions
            e.printStackTrace();
        }
    }
}
