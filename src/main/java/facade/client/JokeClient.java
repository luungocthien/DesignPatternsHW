package facade.client;

import facade.SimpleApiFacade;

public class JokeClient {
    public static void main(String[] args) {
        SimpleApiFacade apiFacade = new SimpleApiFacade();
        String jokeApiUrl = "https://api.chucknorris.io/jokes/random";

        try {
            String joke = apiFacade.getAttributeValueFromJson(jokeApiUrl, "value");
            System.out.println("Random Chuck Norris Joke: ");
            System.out.println(joke);
        } catch (Exception e) {
            System.err.println("Error fetching joke: " + e.getMessage());
        }
    }
}

