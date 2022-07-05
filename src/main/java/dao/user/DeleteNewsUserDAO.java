package dao.user;

import dao.AbstractDAO;
import model.user.ListNewsUserModel;

public class DeleteNewsUserDAO extends AbstractDAO<ListNewsUserModel> {
    public void deleteNews(int id){
        String sql = "delete from news where id = ?";
        update(sql,id);
    }
}
