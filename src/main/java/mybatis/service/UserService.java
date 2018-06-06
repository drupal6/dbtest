package mybatis.service;

import mybatis.beans.impl.User;
import mybatis.mapper.impl.UserMapper;
import mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {

    public static void main(String[] args) {
        insertUser();
        User user = selectUserById(1);
        System.out.print(user.toString());
        user.setAccount(4000.0);
        updateUser(user);
        user = selectUserById(1);
        System.out.print(user.toString());
    }

    public static void insertUser() {
        User user = new User();
        user.setUsername("mybatis1");
        user.setPassword("mybatis1");
        user.setAccount(3000.00);

        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.insertUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void updateUser(User user) {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.updateUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteUser(int id) {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static User selectUserById(int id) {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = null;
        try {
            user = mapper.selectUserById(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public static List<User> selectAllUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = null;
        try {
            list = mapper.selectAllUser();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
