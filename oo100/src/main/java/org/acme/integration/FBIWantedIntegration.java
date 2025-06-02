package org.acme.integration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.acme.business.Student;
import org.acme.business.IPartnerIntegration;


public class FBIWantedIntegration implements IPartnerIntegration{

    private static final String API_URL = "https://api.fbi.gov/wanted/v1/list?field_offices=detroit";


    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class FBIWantedResponse {
        public int total;
        public List<FBIWantedItem> items;

        public int getTotal() {
            return total;
        }

        public List<FBIWantedItem> getItems() {
            return items;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class FBIWantedItem {
        public String title;
        public int reward_max;

        public String getTitle() {
            return title;
        }

        public int getReward_max() {
            return reward_max;
        }
    }

    public List<Student> getStudents() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                FBIWantedResponse fbiResponse = objectMapper.readValue(response.body(), FBIWantedResponse.class);

                return fbiResponse.getItems().stream()
                        .map(item -> new Student(item.getTitle(), item.getReward_max()))
                        .collect(Collectors.toList());
            } else {
                System.err.println("Failed to fetch data: HTTP Status Code " + response.statusCode());
                return Collections.emptyList();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error while making HTTP request or parsing JSON: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        FBIWantedIntegration integration = new FBIWantedIntegration();
        List<Student> students = integration.getStudents();

        if (!students.isEmpty()) {
            System.out.println("List of Students:");
            students.forEach(System.out::println);
        } else {
            System.out.println("No students found or an error occurred.");
        }
    }
}