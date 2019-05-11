package dev.obsydian.securedaccess.service;

import dev.obsydian.securedaccess.domain.Role;
import dev.obsydian.securedaccess.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role findByRole(final String role) {
		return roleRepository.findByRole(role);
	}

	public Role save(final Role role) {
		return roleRepository.save(role);
	}


}
