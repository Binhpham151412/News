package dao.admin;

import dao.AbstractDAO;
import mapper.admin.CategoriesMapper;
import model.admin.CategoriesModel;

import java.util.List;

public class CategoriesDAO
    extends AbstractDAO<CategoriesModel> {

    public List<CategoriesModel> findAll() {
        String sql = "select * from categories";
        return query(sql, new CategoriesMapper());
    }

    public List<CategoriesModel> check(String name) {
        String sql = "select * from categories where name = ?";
        return query(sql, new CategoriesMapper(), name);
    }

    public int addCategory(CategoriesModel categoriesModel) {
        String sql = "insert into categories (name) values (?)";
        return insert(sql, categoriesModel.getName());
    }

    public List<CategoriesModel> findOne(int id) {
        String sql = "select * from categories where id = ?";
        return query(sql, new CategoriesMapper(), id);
    }

    public void updateCategory(CategoriesModel categoriesModel) {
        String sql = "update categories set name = ? where id=? ";
        update(sql,categoriesModel.getName(), categoriesModel.getId());
    }

    public void deleteCategory(CategoriesModel categoriesModel){
        String sql = "delete from categories where id = ?";
        update(sql,categoriesModel.getId());
    }
}
