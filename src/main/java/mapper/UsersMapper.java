package mapper;

import model.UsersModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper
    implements IRowMapper<UsersModel> {
    @Override
    public UsersModel mapRow(final ResultSet resultSet) {
        try {
            return UsersModel.builder()
                             .id(resultSet.getInt("id"))
                             .userName(resultSet.getString("user_name"))
                             .passWord(resultSet.getString("pass_word"))
                             .lastName(resultSet.getString("last_name"))
                             .birthDate(resultSet.getTimestamp("birth_date"))
                             .gender(resultSet.getString("gender"))
                             .createdDate(resultSet.getTimestamp("created_date"))
                             .createdBy(resultSet.getString("created_by"))
                             .modifiedDate(resultSet.getTimestamp("modified_date"))
                             .modifiedBy(resultSet.getString("modified_by"))
                             .role(resultSet.getInt("role"))
                             .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
