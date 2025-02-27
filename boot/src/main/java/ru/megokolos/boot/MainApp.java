//package ru.megokolos.boot;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import ru.megokolos.boot.model.Car;
//import ru.megokolos.boot.model.User;
//import ru.megokolos.boot.service.UserService;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class MainApp {
//
//    public static void main(String[] args) throws SQLException {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//
//        UserService userService = context.getBean(UserService.class);
//
//        Car car1 = new Car("audi", 80);
//        Car car2 = new Car("mers", 63);
//        Car car3 = new Car("bmw", 5);
//        Car car4 = new Car("lada", 9);
//
//        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));
//
//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println();
//        }
//
//        List<User> usersAndCars = userService.getUserByCarModelAndSeries("audi", 80);
//
//        for (User user : usersAndCars) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println(user.getCar());
//        }
//
//        context.close();
//    }
//}
