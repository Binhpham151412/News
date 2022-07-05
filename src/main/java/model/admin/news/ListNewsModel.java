package model.admin.news;

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
public class ListNewsModel {
    private int id;
    private String title;
    private String categoryName;
    private String userName;
}
