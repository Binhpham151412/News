package model.admin.news;

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
public class NewsModel {
    private int id;
    private String content;
    private String description;
    private String title;
    private CategoriesModel categoriesId;
    private String views;
    private String createdDate;
    private String createdBy;
    private String modifiedDate;
    private String modifiedBy;
    private UsersModel userName;

}
