package app;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        userRepository.addUser(new User(1, "Bob Miller", "bob78@gmail.com"));
        userRepository.addUser(new User(2, "Kate Smith", "kate91@gmail.com"));
        userRepository.addUser(new User(3, "Tom Brown", "tom89@gmail.com"));

        int searchId = 1;
        Optional<User> userById = userRepository.findUserById(searchId);
        userById.ifPresentOrElse(
                user -> System.out.println("User found:" + user),
                () -> System.out.println("User ID" + searchId + "not found")
        );

        String searchEmail = "neight43.@example.com";
        Optional<User> userByEmail = userRepository.findUserByEmail(searchEmail);
        userByEmail.ifPresentOrElse(
                user -> System.out.println("User found: " + user),
                () -> System.out.println("\n User with email - " + searchEmail + " not found")
        );

        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> {
                    System.out.print("\n Number of users: " + users.size());
                    users.forEach(System.out::print);
                },
                () -> System.out.println("The user list is empty"));
    }
}