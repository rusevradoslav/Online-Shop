package online_shop.app.service.impl;

import lombok.*;
import online_shop.app.models.entity.Category;
import online_shop.app.models.entity.CategoryName;
import online_shop.app.models.service.CategoryServiceModel;
import online_shop.app.repositoy.CategoryRepository;
import online_shop.app.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    @Override
    public void seedCategories() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values()).forEach(
                    categoryName -> {
                        this.categoryRepository.saveAndFlush(
                                new Category(categoryName,
                                        String.format("Description for %s: ",categoryName.name())));
                    }
            );
        }
    }

    @Override
    public CategoryServiceModel findCategoryByName(CategoryName name) {

      return   this.categoryRepository.findFirstByCategoryName(name).map(category -> modelMapper.map(category,CategoryServiceModel.class)).orElse(null);
    }
}
