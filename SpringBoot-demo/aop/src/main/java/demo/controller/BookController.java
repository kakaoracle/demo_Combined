package demo.controller;

import demo.annotation.AntiDupSubmit;

@RestController
@RequestMapping("/city")
public class BookController {

    @AntiDupSubmit(key = "city:arg[0]")
    @GetMapping
    public String query(@RequestParam String token) {
        return "ok- " + token;
    }
}

