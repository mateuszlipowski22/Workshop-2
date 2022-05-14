public class MainDao {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setUserName("arek");
//        user.setEmail("arkadiusz.jozwiak@coderslab.pl");
//        user.setPassword("pass");
//        userDao.create(user);

        User read = userDao.read(8);
        System.out.println(read);

        User readNotExist = userDao.read(10);
        System.out.println(readNotExist);

        User userToUpdate = userDao.read(8);
        userToUpdate.setUserName("Arkadiusz");
        userToUpdate.setEmail("arek@coderslab.pl");
        userToUpdate.setPassword("superPassword");
        userDao.update(userToUpdate);

        User secondUser = new User();
        secondUser.setUserName("marek");
        secondUser.setEmail("marek@coderslab.pl");
        secondUser.setPassword("pass");
        userDao.create(secondUser);
        User[] all = userDao.findAll();
        for (User u : all) {
            System.out.println(u);
        }


//        UserDao userDao = new UserDao();
//        User user;
//        user = userDao.read(1);
//        user.setEmail("nowakjan@yahoo.com");
//        userDao.update(user);
//
//        userDao.findAll();
//
//        User user1 = new User();
//        user1.setUserName("Marek");
//        user1.setEmail("marek.jozwiak@coderslab.pl");
//        user1.setPassword("Superpass");
//        userDao.delete(5);
//        userDao.create(user1);
//        System.out.println("user1.getUserName() = " + user1.getUserName());
//        userDao.printAll();
//        userDao.deleteAll();

    }

}
