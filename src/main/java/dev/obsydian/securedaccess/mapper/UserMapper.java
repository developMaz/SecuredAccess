/*
package dev.obsydian.securedaccess.mapper;

import dev.obsydian.securedaccess.domain.User;
import dev.obsydian.securedaccess.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

	public User mapToUser(final UserDto userDto) {
		return new User(userDto.getId(), userDto.getRealName(), userDto.getUserName(), userDto.getUserMail(), userDto.getPassword(), userDto.getBirthDate());
	}

	public UserDto mapToUserDto(final User user) {
		return new UserDto(user.getId(), user.getRealName(), user.getUserName(), user.getUserMail(), user.getPassword(), user.getBirthDate());
	}

	public List<UserDto> mapToUserDtoList(final List<User> userList) {
		return userList.stream()
				.map(user -> new UserDto(user.getId(), user.getRealName(), user.getRealName(), user.getUserMail(), user.getPassword(), user.getBirthDate()))
				.collect(Collectors.toList());
	}
}
*/
