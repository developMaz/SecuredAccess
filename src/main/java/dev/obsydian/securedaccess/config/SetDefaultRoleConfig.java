package dev.obsydian.securedaccess.config;

import dev.obsydian.securedaccess.domain.Role;
import dev.obsydian.securedaccess.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SetDefaultRoleConfig implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private RoleService roleService;

	private void checkIfRoleExistAndSave(Role role) {
		Role checkRole = roleService.findByRole(role.getRole());

		if (checkRole == null) {
			roleService.save(new Role(role.getRole()));
		}
	}

	private void generateDefaultRole() {
		checkIfRoleExistAndSave(new Role("USER"));
		checkIfRoleExistAndSave(new Role("ADMIN"));
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		generateDefaultRole();
	}
}
