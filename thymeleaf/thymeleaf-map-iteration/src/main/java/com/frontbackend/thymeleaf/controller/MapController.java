package com.frontbackend.thymeleaf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.frontbackend.thymeleaf.model.Car;
import com.frontbackend.thymeleaf.service.CarService;

@Controller
public class MapController {

    private static SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");

    private final CarService carService;

    @Autowired
    public MapController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String getMap(Model model) throws ParseException {
        model.addAttribute("carsByColor", carService.randomCars()
                                                    .stream()
                                                    .collect(Collectors.groupingBy(Car::getColor)));

        model.addAttribute("carsByProductionYear", carService.randomCars()
                                                             .stream()
                                                             .collect(Collectors.groupingBy(
                                                                     car -> yearFormatter.format(
                                                                             car.getProductionDate()))));
        return "maps";
    }
}
