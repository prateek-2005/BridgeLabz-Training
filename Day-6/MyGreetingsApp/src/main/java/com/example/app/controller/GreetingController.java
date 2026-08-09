package com.example.app.controller;

import com.example.app.model.Greeting;
import com.example.app.service.GreetingService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService service;

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Spring MVC is working!";
    }
    // READ ALL
    @GetMapping
    public String getGreetings(Model model) {

        model.addAttribute("greetings", service.getAll());

        return "greetings";
    }

    // READ ONE
    @GetMapping("/{id}")
    @ResponseBody
    public Greeting getGreeting(@PathVariable("id") int id) {

        return service.getById(id);
    }

    // CREATE
    @PostMapping
    public String createGreeting(
            @RequestParam("message") String message) {

        service.create(message);

        return "redirect:/greetings";
    }

    // UPDATE
    @PostMapping("/{id}/update")
    public String updateGreeting(
            @PathVariable("id") int id,
            @RequestParam("message") String message) {

        service.update(id, message);

        return "redirect:/greetings";
    }

    // DELETE
    @PostMapping("/{id}/delete")
    public String deleteGreeting(
            @PathVariable("id") int id) {

        service.delete(id);

        return "redirect:/greetings";
    }
}