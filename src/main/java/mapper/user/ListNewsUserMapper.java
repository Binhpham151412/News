package mapper.user;

import mapper.IRowMapper;
import model.admin.CategoriesModel;
import model.user.ListNewsUserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListNewsUserMapper
    implements IRowMapper<ListNewsUserModel> {
    @Override
    public ListNewsUserModel mapRow(final ResultSet resultSet) {
        try {
            return ListNewsUserModel.builder()
                                    .id(resultSet.getInt("id"))
                                    .content(resultSet.getString("content"))
                                    .description(resultSet.getString("description"))
                                    .title(resultSet.getString("title"))
                                    .categoryName(CategoriesModel.builder()
                                                                 .name(resultSet.getString("category_name"))
                                                                 .build())
                                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
