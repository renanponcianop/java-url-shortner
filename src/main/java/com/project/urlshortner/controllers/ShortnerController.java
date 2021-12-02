package com.project.urlshortner.controllers;

import com.project.urlshortner.models.DTO.UrlDto;
import com.project.urlshortner.models.entities.Url;
import com.project.urlshortner.service.ShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/shortner")
public class ShortnerController {

    @Autowired
    ShortnerService service;

    @PostMapping
    public ResponseEntity<?> shortUrl(@Valid @RequestBody UrlDto url){
        service.insert(url);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getURL(@RequestParam("prefix") String prefix){
        Url url = service.findByPrefix(prefix);
        UrlDto urlDto = new UrlDto(url);
        return ResponseEntity.ok().body(urlDto);
    }
}
