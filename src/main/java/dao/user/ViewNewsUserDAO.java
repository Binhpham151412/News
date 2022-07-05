package dao.user;

import dao.AbstractDAO;
import mapper.user.ViewNewsUserMapper;
import model.user.ListNewsUserModel;

import java.util.List;

public class ViewNewsUserDAO
    extends AbstractDAO<ListNewsUserModel> {
    public ListNewsUserModel findOne(int id) {
        String sql = "select * from news where id = ?";
        List<ListNewsUserModel> list = query(sql, new ViewNewsUserMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }
}
