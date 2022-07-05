package mapper.user;

import mapper.IRowMapper;
import model.user.ListNewsUserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewNewsUserMapper
    implements IRowMapper {
    @Override
    public Object mapRow(final ResultSet resultSet) {
        try {
            return ListNewsUserModel.builder()
                                    .content(resultSet.getString("content"))
                                    .description(resultSet.getString("description"))
                                    .title(resultSet.getString("title"))
                                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
