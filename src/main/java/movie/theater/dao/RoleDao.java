package movie.theater.dao;

import movie.theater.model.Role;
import movie.theater.model.RolesEnum;

public interface RoleDao {
    Role add(Role role);

    Role getRoleByName(RolesEnum roleName);
}
