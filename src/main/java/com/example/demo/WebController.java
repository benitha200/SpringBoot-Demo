package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controller for serving HTML pages using Thymeleaf templates.
 */
@Controller
public class WebController {

    /**
     * Redirects root path to home page.
     * 
     * @return String redirect to home endpoint
     */
    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    /**
     * Serves the main webpage.
     * 
     * @param model Model object to pass data to the view
     * @return String name of the template to render
     */
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("greeting", "Welcome to Spring Boot Web Application!");
        model.addAttribute("timestamp", getCurrentTime());
        model.addAttribute("deployment", "ArgoCD");
        model.addAttribute("status", "Application is running successfully");
        return "home"; // This will look for templates/home.html
    }

    /**
     * Serves an about page.
     * 
     * @param model Model object to pass data to the view
     * @return String name of the template to render
     */
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About Our Application");
        model.addAttribute("description", "This is a Spring Boot web application with REST API endpoints.");
        model.addAttribute("features", new String[]{
            "REST API endpoints",
            "Web page rendering with Thymeleaf",
            "Health monitoring",
            "Automated deployment with ArgoCD"
        });
        return "about";
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