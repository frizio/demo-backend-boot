package dev.frizio.web.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @Value("${team.developer.name}")
    private String devName;

    @GetMapping("/demo")
    public String demo() {
        String out = "";
        out+=  "Time on server is " + LocalDateTime.now() + "\n";
        out += "Java version on the server machine: " + System.getProperty("java.version") + "\n";
        out += "Developer: " + devName;
        return out;
    }
    
}
