package com.example.final_backend.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    
  @GetMapping("/")
  public String hello() {
    return "hello world!";
  }

  @GetMapping("/error")
  public String error() {
    return "error";
  }
}
