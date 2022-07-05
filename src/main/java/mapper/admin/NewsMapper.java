package mapper.admin;

import mapper.IRowMapper;
import model.admin.CategoriesModel;
import model.admin.news.NewsModel;
import model.UsersModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper
    implements IRowMapper<NewsModel> {
    @Override
    public NewsModel mapRow(final ResultSet resultSet) {
        try {
            return NewsModel.builder()
                            .id(resultSet.getInt("id"))
                            .content("content")
                            .title("title")
                            .views("views")
                            .modifiedBy("modified_by")
                            .modifiedDate("modified_date")
                            .description("description")
                            .createdBy("create_by")
                            .createdDate("created_date")
                            .categoriesId(CategoriesModel.builder().id(Integer.parseInt("id")).build())
                            .userName(UsersModel.builder().userName("user_name").build())
                            .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
