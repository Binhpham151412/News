package dao.user;

import dao.AbstractDAO;
import model.user.AddNewsUserModel;

public class AddNewsUserDAO
    extends AbstractDAO<AddNewsUserModel> {
    public void addNews(AddNewsUserModel addNewsUserModel) {
        String sql = "insert into news (content, description, title, categories_id, users_id) values (?, ?, ?, ?, ? )";
        insert(sql, addNewsUserModel.getContent(), addNewsUserModel.getDescription(),
                      addNewsUserModel.getTitle(), addNewsUserModel.getCategoryName().getId(),
                      addNewsUserModel.getUserName().getId());
    }
}
