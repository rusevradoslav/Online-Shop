package online_shop.app.service.impl;

import lombok.RequiredArgsConstructor;
import online_shop.app.models.entity.User;
import online_shop.app.models.service.UserServiceModel;
import online_shop.app.repositoy.UserRepository;
import online_shop.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel,User.class);

        return this.modelMapper.map(userRepository.saveAndFlush(user),UserServiceModel.class);
    }

    @Override
    public UserServiceModel getUserByUsername(String username) {

        return this.userRepository.findFirstByUsername(username).map(user -> this.modelMapper.map(user,UserServiceModel.class)).orElse(null);
    }
}
