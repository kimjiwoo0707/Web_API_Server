package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebApiServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApiServerApplication.class, args);
    }
}

// REST 컨트롤러 추가
@RestController
class MainController {

    @GetMapping("/")
    public String home() {
        StringBuilder response = new StringBuilder("Hello and welcome!<br>");
        for (int i = 1; i <= 5; i++) {
            response.append("i = ").append(i).append("<br>");
        }
        return response.toString();
    }
}
