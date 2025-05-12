package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for handling hello endpoint requests.
 * Enhanced to provide both text and JSON responses.
 */
@RestController
public class HelloController {

    /**
     * Returns a greeting message in plain text format.
     * 
     * @return String greeting message
     */
    @GetMapping(value = "/greeting", produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloText() {
        return "👋👋 Hello from Spring Boot!\n" + 
               "Successfully updated: " + getCurrentTime() + "\n" +
               "This deployment was triggered by ArgoCD";
    }
    
    /**
     * Returns a greeting message in JSON format.
     * 
     * @return ResponseEntity containing greeting data
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> helloJson() {
        Map<String, Object> response = new HashMap<>();
        response.put("greeting", "Hello from Spring Boot!");
        response.put("updated", true);
        response.put("timestamp", getCurrentTime());
        response.put("deployment", "ArgoCD");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Returns the server health status.
     * 
     * @return ResponseEntity containing health status
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "UP");
        status.put("timestamp", getCurrentTime());
        
        return ResponseEntity.ok(status);
    }
    
    /**
     * Gets the current formatted time.
     * 
     * @return String containing formatted current time
     */
    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}