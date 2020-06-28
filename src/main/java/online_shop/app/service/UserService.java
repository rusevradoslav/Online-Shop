package online_shop.app.service;

import online_shop.app.models.service.UserServiceModel;

import java.math.BigDecimal;

public interface UserService {

    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel getUserByUsername(String username);

    void updateUserBudget(UserServiceModel user, BigDecimal newSum);
}
