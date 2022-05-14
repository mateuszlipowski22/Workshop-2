import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Arrays;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO workshop2.users(username, email, password) VALUES (?, ?, ?);";
    private static final String SELECT_USER_QUERY = "SELECT username, email, password FROM workshop2.users WHERE id=?;";
    private static final String UPDATE_USER_QUERY = "UPDATE workshop2.users SET username=?, email=?, password=? WHERE id=?;";
    private static final String DELETE_USER_QUERY = "DELETE FROM workshop2.users where id = ?";

    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User read(int userId){
        User user = new User();
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(SELECT_USER_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(userId);
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user){
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(UPDATE_USER_QUERY);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int userId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement =
                     conn.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User[] findAll(){
        String dbSize="SELECT id FROM workshop2.users ORDER BY id;";
        try (Connection conn = DbUtil.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(dbSize);
            User[] users = new User[0];
            while(rs.next()) {
                int id = rs.getInt("id");
                addToArray(read(id),users);
                System.out.println(read(id).toString());
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }

    public void deleteAll(){
        String deleteAll="DELETE FROM workshop2.users;;";
        try (Connection conn = DbUtil.getConnection()) {
            Statement statement = conn.createStatement();
            statement.executeUpdate(deleteAll);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAll(){
        try(Connection conn = DbUtil.getConnection()) {
            String selectAll = "SELECT id, username, email FROM workshop2.users";
            Statement statement = conn.createStatement();
            ResultSet resultSetMovie = statement.executeQuery(selectAll);
            System.out.printf("%3s | %30s | %30s%n", "id", "username", "email");
            while (resultSetMovie.next()) {
                int id = resultSetMovie.getInt("id");
                String username = resultSetMovie.getString("username");
                String email = resultSetMovie.getString("email");
                System.out.printf("%3s | %30s | %30s%n", id, username, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
