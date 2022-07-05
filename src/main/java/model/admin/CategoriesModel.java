package model.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoriesModel {
    private int id;
    private String name;
    private String createdDate;
    private String createdBy;
    private String modifiedDate;
    private String modifiedBy;
}
