package dev.obsydian.securedaccess.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(targetEntity = Role.class, mappedBy = "role", fetch = FetchType.EAGER)
	private Set<Role> role;

}
