package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String home() {
        StringBuilder response = new StringBuilder("Hello and welcome!<br>");
        for (int i = 1; i <= 5; i++) {
            response.append("i = ").append(i).append("<br>");
        }
        return response.toString();
    }
}
