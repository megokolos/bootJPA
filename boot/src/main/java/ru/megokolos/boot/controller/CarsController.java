package ru.megokolos.boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import ru.megokolos.boot.service.CarService;

@Controller
public class CarsController {
    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count,
                          @RequestParam(value = "sortBy", required = false) String fieldForSorting,
                          Model model) {
        try {
            model.addAttribute("cars", carService.listCars(count, fieldForSorting));
        } catch (RuntimeException e){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return "cars";
    }
}
