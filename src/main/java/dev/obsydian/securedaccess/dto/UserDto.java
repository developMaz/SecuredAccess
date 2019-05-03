package dev.obsydian.securedaccess.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	private String realName;
	private String userName;
	private String userMail;
	private String password;
	private LocalDate birthDate;
}
