package dev.frizio.web.demo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/demo")
    public String demo() {
        return "Time on server is " + LocalDateTime.now();
    }
    
}
