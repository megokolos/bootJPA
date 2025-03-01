package ru.megokolos.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.UserDTO.UserDTO;
import ru.javamentor.client.IncomeClient;
import ru.megokolos.boot.model.User;
import ru.megokolos.boot.properties.LoanProperties;


@Service
public class LoanServiceImp implements LoanService {

    private final LoanProperties loanProperties;
    private final UserService userService;
    private final IncomeClient incomeClient;
    private static final int MONTHS_IN_FULL_YEAR = 12;

    @Autowired
    public LoanServiceImp(LoanProperties loanProperties, UserService userService,
                          IncomeClient incomeClient) {
        this.loanProperties = loanProperties;
        this.userService = userService;
        this.incomeClient = incomeClient;
    }

    @Override
    public String getLoan(Long id) {
        UserDTO userDTO = incomeClient.getUserDTOById(id);
        User userFromDb = userService.getUserById(id);
        int thisUserIncome = userDTO.getIncome();
        int thisUserCarPrice = userFromDb.getCar().getPrice();
        if (thisUserIncome >= loanProperties.getMinimalIncome() || thisUserCarPrice >= loanProperties.getMinimumCarPrice()) {
            return "Sum - " +
                    (Math.max(thisUserIncome * loanProperties.getPercentFromIncome() * MONTHS_IN_FULL_YEAR,
                            thisUserCarPrice * loanProperties.getPercentFromCarPrice()));
        } else {
            return "No loan";
        }
    }
}
