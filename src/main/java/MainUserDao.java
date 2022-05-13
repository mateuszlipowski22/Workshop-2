import java.util.Scanner;

public class MainUserDao {

    public static void main(String[] args) {

        manuDisplay();
        UserDao userDao = new UserDao();
        try (Scanner scan = new Scanner(System.in)) {
            String userInput = scan.nextLine();
            while(!userInput.equals("x")){
                switch (userInput) {
                    case "u" -> {
                        System.out.println("Please input user id to be deleted (number)");
                        int userToDelete = scan.nextInt();
                        System.out.println("User ID to delete: " + userToDelete);
                        scan.nextLine();
                        System.out.println("Are you sure to delete user with ID=" + userToDelete + " Y/N");
                        String deleteInput = scan.nextLine();
                        if (deleteInput.equals("Y")) {
                            userDao.delete(userToDelete);
                            System.out.println("User with ID=" + userToDelete + " was deleted");
                        } else {
                            System.out.println("Deletion cancelled");
                        }
                    }
                    case "e" -> {
                        System.out.println("Please input user id to be modified (number)");
                        User userEdit = new User();
                        int userToEdit = scan.nextInt();
                        userEdit.setId(userToEdit);
                        System.out.println("User ID to delete: " + userToEdit);
                        scan.nextLine();
                        System.out.println("Please input new user name");
                        String userNameToEdit = scan.nextLine();
                        userEdit.setUserName(userNameToEdit);
                        System.out.println("Please input new user email address");
                        String userEmailToUpdate = scan.nextLine();
                        userEdit.setEmail(userEmailToUpdate);
                        System.out.println("Please input new user password");
                        String userPassToUpdate = scan.nextLine();
                        userEdit.setPassword(userPassToUpdate);
                        System.out.println("Are you sure to update user with ID=" + userToEdit + " Y/N");
                        String editConfirmation = scan.nextLine();
                        if (editConfirmation.equals("Y")) {
                            userDao.update(userEdit);
                            System.out.println("User with ID=" + userToEdit + " was updater");
                        } else {
                            System.out.println("Update cancelled");
                        }
                    }
                    case "a" -> {
                        User userAdd = new User();
                        System.out.println("Please input new user name");
                        String userNameToAdd = scan.nextLine();
                        userAdd.setUserName(userNameToAdd);
                        System.out.println("Please input new user email address");
                        String userEmailToAdd = scan.nextLine();
                        userAdd.setEmail(userEmailToAdd);
                        System.out.println("Please input new user password");
                        String userPassToAdd = scan.nextLine();
                        userAdd.setPassword(userPassToAdd);
                        System.out.println("Are you sure, you want to add new cinema to database - Y/N");
                        String addConfirmation = scan.nextLine();
                        if (addConfirmation.equals("Y")) {
                            userDao.create(userAdd);
                        } else {
                            System.out.println("Addition cancelled");
                        }
                    }
                    case "d" -> {
                        System.out.println("Display user list");
                        userDao.printAll();
                    }
                    case "da" -> {
                        System.out.println("Are you sure to delete all users database Y/N");
                        String deleteAllInput = scan.nextLine();
                        if (deleteAllInput.equals("Y")) {
                            userDao.deleteAll();
                            System.out.println("User database was deleted");
                        } else {
                            System.out.println("Deletion cancelled");
                        }
                    }
                    default -> System.out.println("Incorrect input");
                }
                manuDisplay();
                userInput=scan.nextLine();
            }

        }


    }

    private static void manuDisplay() {
        System.out.println("Please choose correct option:\n" +
                "u - Deletion\n" +
                "x - Exit\n" +
                "e - Edition\n" +
                "d - Display\n" +
                "a - Add\n" +
                "da - Delete all\n");
    }

}
