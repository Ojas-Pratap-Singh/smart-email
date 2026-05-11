package com.email_writer.app;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class EmailGeneratorService {

    private final WebClient webClient;
    @Value("${gemini.api.url}")
    private String geminiAPiUrl;
    @Value("${gemini.api.key}")
    private String geminiAPiKey;

    public EmailGeneratorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String generateEmailReply(EmailRquest emailRquest){
        //build the prompt
        String prompt = buildPrompt(emailRquest);

        // Craft a request
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] {
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );

        //do request
        String response = webClient.post().uri(geminiAPiUrl + geminiAPiKey).header("Content-Type","application/json")
                .bodyValue(requestBody)
                .retrieve().bodyToMono(String.class).block();

        //Extract response and return
        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {
        try {
            ObjectMapper  mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text").asText();
        }catch (Exception e){
            return "Error : " + e.getMessage();
        }
    }

    private String buildPrompt(EmailRquest emailRquest) {

        StringBuilder  prompt = new StringBuilder();
        prompt.append(
                "Generate a professional email reply for the following email content. " +
                        "Do not generate a subject line. " +
                        "Do not use placeholders like [Name], [Your Name], [Company Name], etc. "
        );
        if (emailRquest.getTone() !=null && !emailRquest.getTone().isEmpty()){
            prompt.append("Use a ").append(emailRquest.getTone()).append(" tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailRquest.getEmailContent());
        return prompt.toString() ;
    }
}
