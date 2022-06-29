package com.example.demo2.controllers;

import com.example.demo2.entity.Link;
import com.example.demo2.repository.LinkRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class LinkController {

    private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/link/{id}")
    public String getL(@PathVariable Long id,Model model)
    {
        model.addAttribute("link", linkRepository.findById(id).get());
        return "link/view";
        /*Optional<Link> link=linkRepository.findById(id);
        if(link.isPresent()) {
            model.addAttribute("title", "hello to spring");
            model.addAttribute("link", link.get());
            return "view";
        }
        else return "error";*/
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("links", linkRepository.findAll());
        return "link/list";
    }
}
