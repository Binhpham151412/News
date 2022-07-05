package dao.login;

import dao.AbstractDAO;
import mapper.UsersMapper;
import model.UsersModel;

import java.util.List;

public class LoginDAO
    extends AbstractDAO<UsersModel> {
    public List<UsersModel> findOne(String userName) {
        String sql = "select * from users where user_name=?";
        return query(sql, new UsersMapper(), userName);
    }

    public UsersModel login(final String userName, String password) {
        String sql = "select * from users where user_name = ? and pass_word = ?";
        List<UsersModel> login = query(sql, new UsersMapper(), userName, password);
        return login.isEmpty() ? null : login.get(0);
    }
}
