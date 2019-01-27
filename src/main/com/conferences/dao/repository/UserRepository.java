package conferences.dao.repository;

import conferences.dao.entities.User;

import java.sql.*;

public class UserRepository {

    public User getUserByEmailByPassword(String email, String password) {

    DataSource dataSource = new DataSource();

    String query = "SELECT id_usr, nickname_usr, email_usr, password_usr, role_usr FROM users_usr " +
            "WHERE users_usr.email_usr='" + email + "' AND users_usr.password_usr='" + password + "'";

        try ( Connection conn = dataSource.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
        ) {
        if ( rs.next() ) {
            User user = new User(
                    rs.getLong("id_usr"),
                    rs.getString("nickname_usr"),
                    rs.getString("email_usr"),
                    rs.getString("password_usr"),
                    rs.getInt("role_usr")
            );

            return user;
        }
    } catch (
    SQLException e) {
        e.printStackTrace();
    }

        return null;
}



    public void saveUser(User user) {
        DataSource dataSource = new DataSource();

                try (
                        Connection conn = dataSource.getConnection();
                        PreparedStatement stmt1 = conn.prepareStatement("INSERT INTO users_usr (nickname_usr, email_usr, password_usr, role_usr) VALUES (?,?,?,?)")
                ) {


                    stmt1.setString(1, user.getNickName());
                    stmt1.setString(2, user.getEmail());
                    stmt1.setString(3, user.getPassword());
                    stmt1.setInt(4, user.getRole());
                    stmt1.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


    }


    public User UserExist (String nickname, String email) {

        DataSource dataSource = new DataSource();

        String query = "SELECT id_usr, nickname_usr, email_usr, password_usr, role_usr FROM users_usr " +
                "WHERE users_usr.nickname_usr='" + nickname + "' OR users_usr.email_usr='" + email + "'";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
        ) {
            if (rs.next()) {
                User user = new User(
                        rs.getLong("id_usr"),
                        rs.getString("nickname_usr"),
                        rs.getString("email_usr"),
                        rs.getString("password_usr"),
                        rs.getInt("role_usr")
                );
                return user;
            } ;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    return null;
    }



}
