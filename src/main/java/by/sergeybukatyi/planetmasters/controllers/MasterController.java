package by.sergeybukatyi.planetmasters.controllers;

import by.sergeybukatyi.planetmasters.entities.Master;

import by.sergeybukatyi.planetmasters.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/masters")
public class MasterController {
    final MasterService masterService;

    @Autowired
    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @PostMapping(path = "/save", produces = "application/json")
    public String saveMaster(@RequestParam("name") String name, @RequestParam(value = "age", defaultValue = "0") int age) {
            return masterService.saveMaster(name, age);
    }

    @GetMapping("/getall")
    public List<Master> getAll(){
        return masterService.getAll();
    }

    @GetMapping("/getlazymasters")
    public List<Master> getLazyMasters(){
        return masterService.getMastersWithoutPlanets();
    }

    @GetMapping("/top")
    public List<Master> getTopTenYoungMasters(){
        return masterService.getTenYoungestMasters();
    }
}
