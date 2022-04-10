package com.medium.audhil.controller;

import com.medium.audhil.dao.AlienJPARepo;
import com.medium.audhil.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //  we can get rid of using @ResponseBody on each method
public class AlienRestController {

    @Autowired
    AlienJPARepo alienJPARepo;

//    this method will not accept json in raw format hence we can use @RequestBody as shown below
//    @PostMapping("/alien")
//    public Alien addAlien(Alien alien) {
//        alienJPARepo.save(alien);
//        return alien;
//    }

    @PostMapping(path = "/alien", consumes = {"application/json"})
    //  consumes(shown above) - will restrict user passed data to server as only json format
    public Alien addAlienWithRawData(@RequestBody Alien alien) {
        alienJPARepo.save(alien);
        return alien;
    }

    @GetMapping("/aliens")
    public List<Alien> getAliens() {
        return alienJPARepo.findAll();
    }

    @GetMapping("/aliens/{id}")
    public Optional<Alien> getAlienById(@PathVariable int id) {
        return alienJPARepo.findById(id);
    }

    @DeleteMapping("/aliens/{id}")
    public String deleteAlien(@PathVariable int id) {
        Alien alien = alienJPARepo.getById(id);
        alienJPARepo.delete(alien);
        return "Delete Successful";
    }

    @PutMapping(path = "/alien", consumes = {"application/json"})
    public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
        alienJPARepo.save(alien);
        return alien;
    }
}
