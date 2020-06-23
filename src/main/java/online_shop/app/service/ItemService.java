package online_shop.app.service;

import online_shop.app.models.service.ItemServiceModel;
import online_shop.app.models.view.ItemViewModel;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    void addItem(ItemServiceModel map);

    List<ItemViewModel> findAllItems();

 ItemViewModel findById(String id);

}
