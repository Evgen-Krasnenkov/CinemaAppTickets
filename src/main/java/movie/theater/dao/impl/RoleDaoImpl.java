package movie.theater.dao.impl;

import movie.theater.dao.AbstractDao;
import movie.theater.dao.RoleDao;
import movie.theater.model.Role;
import movie.theater.model.RolesEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Role getRoleByName(RolesEnum roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> getRoleByName = session.createQuery(
                    "From Role WHERE name = :name", Role.class);
            getRoleByName.setParameter("name", roleName);
            return getRoleByName.uniqueResult();
        } catch (Exception e) {
            throw new RuntimeException("Role " + roleName + " not found");
        }
    }
}
