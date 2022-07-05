package dao.user;

import dao.AbstractDAO;
import mapper.user.ListNewsUserMapper;
import model.user.ListNewsUserModel;

import java.util.List;

public class ListNewsUserDAO
    extends AbstractDAO<ListNewsUserModel> {
    public List<ListNewsUserModel> findAll(int userId) {
        String sql = "select n.id, n.content, n.description, n.title, c.name as category_name" +
            " from news as n join categories as c on n.categories_id = c.id" +
            " join users as u on u.id = n.users_id" +
            " where u.id = ?";
        return query(sql, new ListNewsUserMapper(), userId);
    }
}