package by.sergeybukatyi.planetmasters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("setmaster")
    public String setMaster(){
        return "setmaster";
    }

    @GetMapping("createmaster")
    public String createMasterPage(){
        return "createmaster";
    }

    @GetMapping("createplanet")
    public String createPlanetPage(){
        return "createplanet";
    }
}
