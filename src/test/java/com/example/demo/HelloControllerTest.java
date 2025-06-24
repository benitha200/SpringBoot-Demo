package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

     @TestConfiguration
    static class TestConfig {
        @Bean
        public MeterRegistry meterRegistry() {
            return new SimpleMeterRegistry();
        }
    }

    @Test
    void textEndpointShouldReturnGreeting() throws Exception {
        mockMvc.perform(get("/greeting").accept(MediaType.TEXT_PLAIN))
               .andExpect(status().isOk())
               .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
               .andExpect(content().string(containsString("Hello from Spring Boot")))
               .andExpect(content().string(containsString("Successfully updated")))
               .andExpect(content().string(containsString("ArgoCD")));
    }
        
    @Test
    void jsonEndpointShouldReturnGreetingObject() throws Exception {
        // Updated from "/" to "/api"
        mockMvc.perform(get("/api").accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.greeting").value("Hello from Spring Boot!!"))
               .andExpect(jsonPath("$.updated").value(true))
               .andExpect(jsonPath("$.timestamp").isString())
               .andExpect(jsonPath("$.deployment").value("ArgoCD"));
    }
        
    @Test
    void healthEndpointShouldReturnUpStatus() throws Exception {
        mockMvc.perform(get("/health"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.status").value("UP"))
               .andExpect(jsonPath("$.timestamp").isString());
    }
}