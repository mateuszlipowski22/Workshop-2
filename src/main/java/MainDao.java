public class MainDao {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        User user;
        user = userDao.read(1);
        user.setEmail("nowakjan@yahoo.com");
        userDao.update(user);

        userDao.findAll();

        User user1 = new User();
        user1.setUserName("Marek");
        user1.setEmail("marek.jozwiak@coderslab.pl");
        user1.setPassword("Superpass");
        userDao.delete(5);
        userDao.create(user1);
        System.out.println("user1.getUserName() = " + user1.getUserName());
        userDao.printAll();
//        userDao.deleteAll();

    }

}
