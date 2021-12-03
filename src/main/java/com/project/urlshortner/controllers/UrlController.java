package com.project.urlshortner.controllers;

import com.project.urlshortner.models.entities.Url;
import com.project.urlshortner.service.ShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/redirect")
public class UrlController {

    @Autowired
    ShortnerService service;

    @GetMapping("/{prefix}")
    public RedirectView getURL(@PathVariable String prefix){
        Url url = service.findAndRedirect(prefix);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url.getUrl());
        return redirectView;
    }

    @GetMapping("/")
    public String defaultNotFound() {
        return "not-found";
    }
}
