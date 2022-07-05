package dao.login;

import dao.AbstractDAO;
import mapper.UsersMapper;
import model.UsersModel;

import java.util.List;

public class AddUserDAO
    extends AbstractDAO<UsersModel> {
    public List<UsersModel> check(String username) {
        String sql = "select * from users where user_name = ?";
        return query(sql, new UsersMapper(), username);
    }


    public void addUser(UsersModel usersModel) {
        String sql = "insert into users (user_name,first_name, last_name, pass_word,gender, role) values (?,?,?,?,?,1)";
        insert(sql, usersModel.getUserName(),usersModel.getFirstName(),usersModel.getLastName(),
               usersModel.getPassWord(), usersModel.getGender());
    }
}
