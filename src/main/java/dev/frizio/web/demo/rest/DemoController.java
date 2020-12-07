package dev.frizio.web.demo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/demo")
    public String demo() {
        String out = "";
        out+=  "Time on server is " + LocalDateTime.now() + "\n";
        out += "Java version on the server machine: " + System.getProperty("java.version") + "\n";
        return out;
    }
    
}
