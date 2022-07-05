package mapper.admin;

import mapper.IRowMapper;
import model.admin.CategoriesModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriesMapper
    implements IRowMapper<CategoriesModel> {
    @Override
    public CategoriesModel mapRow(final ResultSet resultSet) {
        try {
            return CategoriesModel.builder()
                                  .id(resultSet.getInt("id"))
                                  .name(resultSet.getString("name"))
                                  .modifiedBy(resultSet.getString("modified_by"))
                                  .modifiedDate(resultSet.getString("modified_date"))
                                  .createdBy(resultSet.getString("created_by"))
                                  .createdDate(resultSet.getString("created_date"))
                                  .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
