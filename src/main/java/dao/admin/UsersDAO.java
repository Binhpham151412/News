package dao.admin;

import dao.AbstractDAO;
import mapper.UsersMapper;
import model.UsersModel;

import java.util.List;

public class UsersDAO
    extends AbstractDAO<UsersModel> {

    public List<UsersModel> findAll() {
        String sql = "select * from users";
        return query(sql, new UsersMapper());
    }
}
