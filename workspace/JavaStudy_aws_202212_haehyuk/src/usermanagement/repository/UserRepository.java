package usermanagement.repository;

import j23_database.DBConnectionMgr;
import usermanagement.entity.RoleDtl;
import usermanagement.entity.RoleMst;
import usermanagement.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *  UserDao (data access object.)
 *
 */
public class UserRepository {

    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private DBConnectionMgr pool;

    private UserRepository() { pool = DBConnectionMgr.getInstance(); }

    /**
     *  회원가입
     */

    public int saveUser(User user) {
        int successCount = 0;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = pool.getConnection();
            String sql = "insert into user_mst values(0,?,?,?,?)";
            pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

            successCount = pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                user.setUserId(rs.getInt(1));;
            }

        } catch (Exception e) {
            e.printStackTrace();;
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        
        return successCount;
    }

    public User findUserByUsername(String username) {
        User user = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = pool.getConnection();
            String sql = "select\n" +
                    "\tum.user_id,\n" +
                    "    um.username,\n" +
                    "    um.password,\n" +
                    "    um.name,\n" +
                    "    um.email,\n" +
                    "    rd.role_dtl_id,\n" +
                    "    rd.role_id,\n" +
                    "    rd.user_id,\n" +
                    "    rm.role_id,\n" +
                    "    rm.role_name\n" +
                    "from\n" +
                    "\tuser_mst um\n" +
                    "    left outer join role_dtl rd on(rd.user_id = um.user_id)\n" +
                    "    left outer join role_mst rm on(rm.role_id = rd.role_id )\n" +
                    "where\n" +
                    "\tum.username = ?;";
            
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            List<RoleDtl> roleDtls = new ArrayList<>();

            int i = 0;
            while (rs.next()) {
                if(i == 0) {
                    user = User.builder()
                            .userId(rs.getInt(1))
                            .username(rs.getString(2))
                            .password(rs.getString(3))
                            .name(rs.getString(4))
                            .email(rs.getString(5))
                            .build();
                }
                
                RoleMst roleMst = RoleMst.builder()
                        .roleId(rs.getInt(9))
                        .roleName(rs.getString(10))
                        .build();

                RoleDtl roleDtl = RoleDtl.builder()
                        .roleDtlId(rs.getInt(6))
                        .roleId(rs.getInt(7))
                        .userId(rs.getInt(8))
                        .roleMst(roleMst)
                        .build();

                roleDtls.add(roleDtl);
                
                i++;
            }
            
            if (user != null) {
            	user.setRoleDtls(roleDtls);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }

        return user;
    }

    public User findUserByEmail(String email) {
        User user = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = pool.getConnection();
            String sql = "select\n" +
                    "\tum.user_id,\n" +
                    "    um.username,\n" +
                    "    um.password,\n" +
                    "    um.name,\n" +
                    "    um.email,\n" +
                    "    rd.role_dtl_id,\n" +
                    "    rd.role_id,\n" +
                    "    rd.user_id,\n" +
                    "    rm.role_id,\n" +
                    "    rm.role_name\n" +
                    "from\n" +
                    "\tuser_mst um\n" +
                    "    left outer join role_dtl rd on(rd.user_id = um.user_id)\n" +
                    "    left outer join role_mst rm on(rm.role_id = rd.role_id )\n" +
                    "where\n" +
                    "\tum.email = ?;";
            
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            List<RoleDtl> roleDtls = new ArrayList<>();

            int i = 0;
            while (rs.next()) {
                if(i == 0) {
                    user = User.builder()
                            .userId(rs.getInt(1))
                            .username(rs.getString(2))
                            .password(rs.getString(3))
                            .name(rs.getString(4))
                            .email(rs.getString(5))
                            .build();
                }
                RoleMst roleMst = RoleMst.builder()
                        .roleId(rs.getInt(9))
                        .roleName(rs.getString(10))
                        .build();

                RoleDtl roleDtl = RoleDtl.builder()
                        .roleDtlId(rs.getInt(6))
                        .roleId(rs.getInt(7))
                        .userId(rs.getInt(8))
                        .roleMst(roleMst)
                        .build();
                
               	roleDtls.add(roleDtl);
                
                i++;
            }
            
            if (user != null) {
            	user.setRoleDtls(roleDtls);
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }

        return user;
    }

}
