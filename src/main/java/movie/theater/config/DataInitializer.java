package movie.theater.config;

import java.util.Set;
import javax.annotation.PostConstruct;
import movie.theater.model.Role;
import movie.theater.model.RolesEnum;
import movie.theater.model.User;
import movie.theater.service.RoleService;
import movie.theater.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(RolesEnum.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(RolesEnum.USER);
        roleService.add(userRole);
        User admin = new User();
        admin.setEmail("admin@mate.ua");
        admin.setPassword("12345");
        admin.setUserRoles(Set.of(adminRole));
        userService.add(admin);
        User user = new User();
        user.setEmail("user@mate.ua");
        user.setPassword("12345");
        user.setUserRoles(Set.of(userRole));
        userService.add(user);
    }
}
