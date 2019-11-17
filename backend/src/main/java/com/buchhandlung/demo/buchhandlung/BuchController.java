package com.buchhandlung.demo.buchhandlung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuchController {

    @Autowired
    private BuchService buchService;

    @GetMapping("/buchs/{id}")
    public Buch getBuch(@PathVariable int id) {
        return this.buchService.getBuch(id);
    }

    @PostMapping("/buchs")
    public Buch createBuch(@RequestBody Buch newBuch) {
        return this.buchService.createBuch(newBuch);
    }

    @PutMapping("/buchs/{id}")
    public Buch updateBuch(@PathVariable int id, @RequestBody Buch updatedBuch) {
        return this.buchService.updateBuch(id, updatedBuch);
    }

    @DeleteMapping("buchs/{id}")
    public Buch removeBuch(@PathVariable int id) {
        return this.buchService.removeBuch(id);
    }

    @GetMapping("/buchs")
    public List<Buch> getAllBuch() {
        return this.buchService.getAllBuch();
    }


}
