package online_shop.app.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop.app.models.entity.CategoryName;



@Getter
@Setter
@NoArgsConstructor
public class CategoryServiceModel extends BaseServiceModel {

    private CategoryName categoryName;

    private String description;

}
