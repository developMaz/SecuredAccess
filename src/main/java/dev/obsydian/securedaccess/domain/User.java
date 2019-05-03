package dev.obsydian.securedaccess.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@DynamicUpdate
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private int id;

	@Column(name = "real_name")
	private String realName;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_mail")
	private String userMail;

	@Column(name = "password")
	private String password;

	@Column(name = "birth_name")
	private LocalDate birthDate;
}
