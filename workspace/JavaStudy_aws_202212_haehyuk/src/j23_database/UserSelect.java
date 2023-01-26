package j23_database;

import usermanagement.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSelect {

    private DBConnectionMgr pool;

    public UserSelect() {
        pool = DBConnectionMgr.getInstance();
    }

    public User findUserByUsername(String username) {
        User user = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = pool.getConnection();
            String sql = "SELECT user_id, username, password, name, email FROM user_mst WHERE username = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = User.builder()
                        .userId(rs.getInt(1))
                        .username(rs.getString(2))
                        .password(rs.getString(3))
                        .name(rs.getString(4))
                        .email(rs.getString(5))
                        .build();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }

        return user;
    }

    public static void main(String[] args) {
        UserSelect userSelect = new UserSelect();

        User user = userSelect.findUserByUsername("aaa");
        System.out.println(user);
    }
}
