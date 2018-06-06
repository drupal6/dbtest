package mybatis.mapper.impl;


import mybatis.beans.impl.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public int insertUser(User user) throws Exception;

    public int updateUser(User user) throws Exception;

    public int deleteUser(int id) throws Exception;

    public User selectUserById(int id) throws Exception;

    public List<User> selectAllUser() throws Exception;
}
