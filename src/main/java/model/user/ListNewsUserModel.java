package model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.admin.CategoriesModel;
import model.UsersModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListNewsUserModel {
    private int id;
    private String content;
    private String description;
    private String title;
    private CategoriesModel categoryName;
    private UsersModel usersModel;
}
