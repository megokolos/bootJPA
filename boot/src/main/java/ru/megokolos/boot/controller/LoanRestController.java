package ru.megokolos.boot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.megokolos.boot.service.LoanService;

@RestController
public class LoanRestController {
    
    @Autowired
    private LoanService loanService;

    @RequestMapping("/loan/{userId}")
    public String getLoanSum(@PathVariable("userId") Long id) {
        return loanService.getLoan(id);
    }
}
