package online_shop.app.init;

import online_shop.app.service.CategoryService;
import online_shop.app.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {


    private final CategoryService categoryService;
    private final RoleService roleService;

    public DataInit(CategoryService categoryService, RoleService roleService) {
        this.categoryService = categoryService;
        this.roleService = roleService;
    }


    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.roleService.seedRoles();
    }


}
