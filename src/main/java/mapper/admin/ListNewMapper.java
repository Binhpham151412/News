package mapper.admin;

import mapper.IRowMapper;
import model.admin.news.ListNewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListNewMapper
    implements IRowMapper<ListNewsModel> {
    @Override
    public ListNewsModel mapRow(final ResultSet resultSet) {
        try {
            return ListNewsModel.builder()
                                .id(resultSet.getInt("id"))
                                .title(resultSet.getString("title"))
                                .categoryName(resultSet.getString("name_category"))
                                .userName(resultSet.getString("user_name"))
                                .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
