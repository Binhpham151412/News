package dao.user;

import dao.AbstractDAO;
import mapper.user.UpdateNewsUserMapper;
import model.user.UpdateNewsUserModel;

import java.util.List;

public class UpdateNewsUserDAO
    extends AbstractDAO<UpdateNewsUserModel> {
    public UpdateNewsUserModel findOne(int id) {
        String sql = "select * from news where id = ?";
        List<UpdateNewsUserModel> list = query(sql, new UpdateNewsUserMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }


    public void update(UpdateNewsUserModel updateNewsUserModel) {
        String sql = "update news set title = ?, description = ?, content = ? where id = ?";
        update(sql, updateNewsUserModel.getTitle(), updateNewsUserModel.getDescription(),
               updateNewsUserModel.getContent(), updateNewsUserModel.getId());
    }
}
