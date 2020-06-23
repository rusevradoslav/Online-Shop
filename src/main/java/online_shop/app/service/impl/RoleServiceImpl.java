package online_shop.app.service.impl;

import lombok.RequiredArgsConstructor;
import online_shop.app.models.entity.Role;
import online_shop.app.repositoy.RoleRepository;
import online_shop.app.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;


    @Override
    public void seedRoles() {
        if (this.roleRepository.count() == 0) {
            Role guest = new Role("GUEST");
            Role user = new Role("USER");
            this.roleRepository.saveAndFlush(user);
            this.roleRepository.saveAndFlush(guest);
        }
    }
}
