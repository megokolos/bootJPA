package ru.megokolos.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.javamentor.UserDTO.UserDTO;
import ru.javamentor.client.IncomeClient;
import ru.megokolos.boot.model.User;
import ru.megokolos.boot.properties.LoanProperties;


import java.util.List;
import java.util.Objects;

@Service
public class LoanServiceImp implements LoanService{

    @Autowired
    LoanProperties loanProperties;

    @Autowired
    private UserService userService;

    @Autowired
    private IncomeClient incomeClient;

    @Override
    public String getLoan(Long id) {
        List<UserDTO> jsonUsers = incomeClient.getUsersIncome();
        for (UserDTO user : jsonUsers) {
            if (Objects.equals(user.getId(), id)) {
                User userfromDb = userService.getUserById(id);

                int thisUserIncome = user.getIncome();
                int thisUserCarPrice = userfromDb.getCar().getPrice();
                if (thisUserIncome >= loanProperties.getMinimalIncome() || thisUserCarPrice >= loanProperties.getMinimumCarPrice()) {
                    return "Sum - " +
                            (Math.max(thisUserIncome * loanProperties.getPercentFromIncome() * 12, thisUserCarPrice * loanProperties.getPercentFromCarPrice()));
                } else {
                    return "No loan";
                }
            }
        }
        return "Error";
    }
}
