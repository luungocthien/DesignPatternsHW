package facade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimpleApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IOException, IllegalArgumentException {
        String jsonResponse = getJsonFromApi(urlString);
        return extractAttribute(jsonResponse, attributeName);
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        HttpURLConnection connection = null;
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();
            if (status != 200) {
                throw new IOException("HTTP request failed with status code: " + status);
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return result.toString();
    }

    private String extractAttribute(String json, String attributeName)
            throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            if (!jsonObject.containsKey(attributeName)) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON.");
            }

            Object value = jsonObject.get(attributeName);
            return value != null ? value.toString() : null;

        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON: " + e.getMessage());
        }
    }
}

