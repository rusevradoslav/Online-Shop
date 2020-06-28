package online_shop.app.service.impl;

import lombok.RequiredArgsConstructor;
import online_shop.app.models.entity.Item;
import online_shop.app.models.service.CategoryServiceModel;
import online_shop.app.models.service.ItemServiceModel;
import online_shop.app.models.service.UserServiceModel;
import online_shop.app.models.view.ItemViewModel;
import online_shop.app.repositoy.ItemRepository;
import online_shop.app.service.CategoryService;
import online_shop.app.service.ItemService;
import online_shop.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class ItemServiceImpl implements ItemService {
    private final ModelMapper modelMapper;
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final UserService userService;


    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

        CategoryServiceModel categoryServiceModel = this.categoryService.findCategoryByName(itemServiceModel.getCategory().getCategoryName());
        System.out.println();
        itemServiceModel.setCategory(categoryServiceModel);
        Item item = this.modelMapper.map(itemServiceModel, Item.class);
        this.itemRepository.saveAndFlush(item);


        System.out.println();
    }

    @Override
    public List<ItemViewModel> findAllItems() {

        return this.itemRepository
                .findAll()
                .stream()
                .map(item -> {
                            ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
                            itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender().name(), item.getCategory().getCategoryName().name()));
                            return itemViewModel;
                        }
                ).collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
        return this.itemRepository
                .findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender().name(), item.getCategory().getCategoryName().name()));
                    return itemViewModel;
                }).orElse(null);
    }

    @Override
    public void delete(UserServiceModel user, ItemViewModel item) {
        user.getBudget().subtract(item.getPrice());
        this.userService.updateUserBudget(user,user.getBudget().subtract(item.getPrice()));
        this.itemRepository.delete(this.modelMapper.map(item,Item.class));
    }


}
