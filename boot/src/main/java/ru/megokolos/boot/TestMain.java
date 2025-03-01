package ru.megokolos.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import ru.megokolos.boot.model.Car;
import ru.megokolos.boot.model.User;
import ru.megokolos.boot.service.UserService;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootApplication.class, args);

        // Получаем бин UserService
        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("audi", 80);
        Car car2 = new Car("mers", 63);
        Car car3 = new Car("bmw", 5);
        Car car4 = new Car("lada", 9);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        List<User> usersAndCars = userService.findAllByCarModelAndCarSeries("audi", 80);

        for (User user : usersAndCars) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println(user.getCar());
        }
    }
}
