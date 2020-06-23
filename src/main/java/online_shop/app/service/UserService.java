package online_shop.app.service;

import online_shop.app.models.service.UserServiceModel;

public interface UserService {

    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel getUserByUsername(String username);

}
