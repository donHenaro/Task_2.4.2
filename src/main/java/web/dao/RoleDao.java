package web.dao;

import web.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    Role getRoleByName (String role);
    List<Role> getRoles();
    Set<Role> getRolesByName(String[] roles);
}
