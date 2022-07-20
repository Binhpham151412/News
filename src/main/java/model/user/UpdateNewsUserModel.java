package model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.UsersModel;
import model.admin.CategoriesModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateNewsUserModel {
    private int id;
    private String content;
    private String description;
    private String title;
    private CategoriesModel categoriesModel;
}
