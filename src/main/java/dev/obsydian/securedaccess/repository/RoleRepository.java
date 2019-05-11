package dev.obsydian.securedaccess.repository;

import dev.obsydian.securedaccess.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByRole(String role);

	Role save(Role role);
}
