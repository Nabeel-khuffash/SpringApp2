package com.example.demo2.controllers;

import com.example.demo2.entity.Link;
import com.example.demo2.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LinkController {

    public static final Logger logger= LoggerFactory.getLogger(LinkController.class);
    private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/link/{id}")
    public String getL(@PathVariable Long id,Model model)
    {
        Optional<Link> link=linkRepository.findById(id);
        if(link.isPresent()) {
            model.addAttribute("title", "hello to spring");
            model.addAttribute("link", link.get());
            return "link/view";
        }
        else return "redirect:/";
    }

    @GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link",new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            logger.info("Validation errors were found while submitting a new link.");
            model.addAttribute("link",link);
            return "link/submit";
        } else {
            // save our link
            linkRepository.save(link);
            logger.info("New Link was saved successfully.");
            redirectAttributes
                    .addAttribute("id", link.getId())
                    .addFlashAttribute("success",true);
            return "redirect:/link/{id}";
        }
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("links", linkRepository.findAll());
        return "link/list";
    }
}
