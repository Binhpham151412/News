package dao.admin;

import dao.AbstractDAO;
import mapper.admin.ListNewMapper;
import model.admin.news.ListNewsModel;
import model.admin.news.NewsModel;

import java.util.List;

public class NewsDAO
    extends AbstractDAO<NewsModel> {
    public List<ListNewsModel> findAll() {

        String sql = "select n.id, n.title , c.name as 'name_category', u.user_name"
            + " from categories as c join news as n on c.id = n.categories_id"
            + " join users as u on n.users_id = u.id";
        return query(sql, new ListNewMapper());
    }
}
