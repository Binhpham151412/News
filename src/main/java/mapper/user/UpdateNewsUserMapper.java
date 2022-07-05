package mapper.user;

import mapper.IRowMapper;
import model.admin.CategoriesModel;
import model.user.ListNewsUserModel;
import model.user.UpdateNewsUserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateNewsUserMapper
    implements IRowMapper<UpdateNewsUserModel> {
    @Override
    public UpdateNewsUserModel mapRow(final ResultSet resultSet) {
        try {
            return UpdateNewsUserModel.builder()
                                      .id(resultSet.getInt("id"))
                                      .content(resultSet.getString("content"))
                                      .description(resultSet.getString("description"))
                                      .title(resultSet.getString("title"))
                                      .categoryId(CategoriesModel.builder()
                                                                 .id(Integer.parseInt(resultSet.getString("categories_id")))
                                                                 .build())
                                      .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
