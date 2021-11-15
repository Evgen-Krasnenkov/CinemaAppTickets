package movie.theater.service.impl;

import java.util.HashSet;
import movie.theater.model.RolesEnum;
import movie.theater.model.User;
import movie.theater.service.AuthenticationService;
import movie.theater.service.RoleService;
import movie.theater.service.ShoppingCartService;
import movie.theater.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUserRoles(new HashSet<>());
        user.getUserRoles().add(roleService.getRoleByName(RolesEnum.USER));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
