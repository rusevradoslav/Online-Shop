package online_shop.app.service;

import online_shop.app.models.entity.CategoryName;
import online_shop.app.models.service.CategoryServiceModel;

public interface CategoryService {
    void seedCategories();
    CategoryServiceModel findCategoryByName(CategoryName name);
}
