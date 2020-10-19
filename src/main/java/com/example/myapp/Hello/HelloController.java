package com.example.myapp.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/api/sayHello")
  public String sayHello() {
    return "Hello World :)";
  }
}
