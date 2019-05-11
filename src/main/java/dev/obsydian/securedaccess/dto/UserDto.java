package dev.obsydian.securedaccess.dto;

import dev.obsydian.securedaccess.domain.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private int id;
	private String firstName;
	private String secondName;
	private String email;
	private String password;
	private boolean enabled;
	private Set<Role> roles;

	public UserDto(String firstName, String secondName, String email, String password) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.password = password;
	}
}