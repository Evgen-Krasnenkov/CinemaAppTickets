package movie.theater.service;

import movie.theater.model.Role;
import movie.theater.model.RolesEnum;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(RolesEnum roleName);
}
