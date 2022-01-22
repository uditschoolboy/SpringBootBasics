package com.example.demo.controller;

import com.example.demo.doa.AlienRepo;
import com.example.demo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlienController {

    @Autowired
    AlienRepo alienRepo;

    @GetMapping("addform")
    public String sendForm() {
        return "form.html";
    }

    @PostMapping("addform")
    @ResponseBody
    public String addData(Alien alien) {
        alienRepo.save(alien);
        return "added successfully";
    }

    @GetMapping("getAlien/{id}")
    @ResponseBody
    public String getAlien(@PathVariable("id") int id) {

        return alienRepo.findById(id).toString();
    }

    @GetMapping("getAlienByTech")
    @ResponseBody
    public List<Alien> getAlienByTech(@RequestParam("tech") String tech) {
        return alienRepo.findByTech(tech);
    }

    @GetMapping("aliens")
    @ResponseBody
    public List<Alien> getAliens() {
        return alienRepo.findAll();
    }
}
