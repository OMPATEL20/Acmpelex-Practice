////package com.acmeplex.util;
////
////import java.io.BufferedReader;
////import java.io.InputStreamReader;
////import java.io.OutputStream;
////import java.net.HttpURLConnection;
////import java.net.URL;
////
////public class ApiClient {
////
////    private static final String BASE_URL = "http://localhost:8080/api/auth";
////
////    // Method for login
////    public static String login(String username, String password) throws Exception {
////        String loginUrl = BASE_URL + "/login";
////        String jsonInputString = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);
////        return sendPostRequest(loginUrl, jsonInputString);
////    }
////
////    // Method for signup
////    public static String signup(String username, String password, String name, String address, String userType) throws Exception {
////        String signupUrl = BASE_URL + "/signup";
////        String jsonInputString = String.format(
////            "{\"username\":\"%s\", \"password\":\"%s\", \"name\":\"%s\", \"address\":\"%s\", \"userType\":\"%s\"}",
////            username, password, name, address, userType
////        );
////        return sendPostRequest(signupUrl, jsonInputString);
////    }
////
////    // Helper method for sending POST requests
////    private static String sendPostRequest(String requestUrl, String jsonInputString) throws Exception {
////        URL url = new URL(requestUrl);
////        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////        conn.setRequestMethod("POST");
////        conn.setRequestProperty("Content-Type", "application/json; utf-8");
////        conn.setDoOutput(true);
////
////        try (OutputStream os = conn.getOutputStream()) {
////            byte[] input = jsonInputString.getBytes("utf-8");
////            os.write(input, 0, input.length);
////        }
////
////        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
////            StringBuilder response = new StringBuilder();
////            String responseLine;
////            while ((responseLine = br.readLine()) != null) {
////                response.append(responseLine.trim());
////            }
////            return response.toString();
////        }
////    }
////}
//
//
//package com.acmeplex.util;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Arrays;
//import java.util.List;
//
//import com.acmeplex.model.Movie;
//import com.acmeplex.model.Seat;
//import com.acmeplex.model.Showtime;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class ApiClient {
//
//    private static final String AUTH_BASE_URL = "http://localhost:8080/api/auth";
//    private static final String BASE_URL = "http://localhost:8080/api";
//    private static final ObjectMapper mapper = new ObjectMapper();
//
//    // Login and signup methods using AUTH_BASE_URL
//    public static String login(String username, String password) throws Exception {
//        String loginUrl = AUTH_BASE_URL + "/login";
//        String jsonInputString = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);
//        return sendPostRequest(loginUrl, jsonInputString);
//    }
//
//    public static String signup(String username, String password, String name, String address, String userType) throws Exception {
//        String signupUrl = AUTH_BASE_URL + "/signup";
//        String jsonInputString = String.format(
//            "{\"username\":\"%s\", \"password\":\"%s\", \"name\":\"%s\", \"address\":\"%s\", \"userType\":\"%s\"}",
//            username, password, name, address, userType
//        );
//        return sendPostRequest(signupUrl, jsonInputString);
//    }
//
//    // Fetch movies using BASE_URL
//    public static List<Movie> getMovies() throws Exception {
//        URL url = new URL(BASE_URL + "/movies");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        return Arrays.asList(mapper.readValue(conn.getInputStream(), Movie[].class));
//    }
//
//    // Fetch showtimes for a movie using BASE_URL
//    public static List<Showtime> getShowtimes(Long movieId) throws Exception {
//        URL url = new URL(BASE_URL + "/showtimes/movie/" + movieId);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        return Arrays.asList(mapper.readValue(conn.getInputStream(), Showtime[].class));
//    }
//
//    // Fetch seats for a showtime using BASE_URL
//    public static List<Seat> getSeats(Long showtimeId) throws Exception {
//        URL url = new URL(BASE_URL + "/seats/showtime/" + showtimeId);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        return Arrays.asList(mapper.readValue(conn.getInputStream(), Seat[].class));
//    }
//
//    // Helper method for sending POST requests
//    private static String sendPostRequest(String requestUrl, String jsonInputString) throws Exception {
//        URL url = new URL(requestUrl);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/json; utf-8");
//        conn.setDoOutput(true);
//
//        try (OutputStream os = conn.getOutputStream()) {
//            byte[] input = jsonInputString.getBytes("utf-8");
//            os.write(input, 0, input.length);
//        }
//
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
//            StringBuilder response = new StringBuilder();
//            String responseLine;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            return response.toString();
//        }
//    }
//}



package com.acmeplex.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.acmeplex.model.Movie;
import com.acmeplex.model.Seat;
import com.acmeplex.model.Showtime;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiClient {

    private static final String AUTH_BASE_URL = "http://localhost:8080/api/auth";
    private static final String BASE_URL = "http://localhost:8080/api";
    private static final ObjectMapper mapper = new ObjectMapper();

    // Login and signup methods using AUTH_BASE_URL
//    public static String login(String username, String password) throws Exception {
//        String loginUrl = AUTH_BASE_URL + "/login";
//        String jsonInputString = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);
//        return sendPostRequest(loginUrl, jsonInputString);
//    }
    public static String login(String username, String password) throws Exception {
        String loginUrl = AUTH_BASE_URL + "/login";
        String jsonInputString = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);
        
        // Debug: Print the JSON request to check formatting
        System.out.println("Request JSON: " + jsonInputString);
        
        return sendPostRequest(loginUrl, jsonInputString);
    }

    public static String signup(String username, String password, String name, String address, String userType) throws Exception {
        String signupUrl = AUTH_BASE_URL + "/signup";
        String jsonInputString = String.format(
            "{\"username\":\"%s\", \"password\":\"%s\", \"name\":\"%s\", \"address\":\"%s\", \"userType\":\"%s\"}",
            username, password, name, address, userType
        );
        return sendPostRequest(signupUrl, jsonInputString);
    }

    // Fetch movies using BASE_URL
    public static List<Movie> getMovies() throws Exception {
        URL url = new URL(BASE_URL + "/movies");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        // Add authorization header if a token is available
        // conn.setRequestProperty("Authorization", "Bearer " + token);
        return Arrays.asList(mapper.readValue(conn.getInputStream(), Movie[].class));
    }

    // Fetch showtimes for a movie using BASE_URL
    public static List<Showtime> getShowtimes(Long movieId) throws Exception {
        URL url = new URL(BASE_URL + "/showtimes/movie/" + movieId);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        // Add authorization header if needed
        // conn.setRequestProperty("Authorization", "Bearer " + token);
        return Arrays.asList(mapper.readValue(conn.getInputStream(), Showtime[].class));
    }

    // Fetch seats for a showtime using BASE_URL
    public static List<Seat> getSeats(Long showtimeId) throws Exception {
        URL url = new URL(BASE_URL + "/seats/showtime/" + showtimeId);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        // Add authorization header if needed
        // conn.setRequestProperty("Authorization", "Bearer " + token);
        return Arrays.asList(mapper.readValue(conn.getInputStream(), Seat[].class));
    }

    // Helper method for sending POST requests
    private static String sendPostRequest(String requestUrl, String jsonInputString) throws Exception {
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read and return the response
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                return response.toString();
            }
        } else {
            throw new Exception("Request failed with HTTP code " + responseCode);
        }
    }

}