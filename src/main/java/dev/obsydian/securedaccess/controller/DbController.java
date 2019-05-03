package dev.obsydian.securedaccess.controller;

import dev.obsydian.securedaccess.dto.UserDto;
import dev.obsydian.securedaccess.mapper.DbMapper;
import dev.obsydian.securedaccess.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user/")
public class DbController {

	@Autowired
	private DbMapper dbMapper;

	@Autowired
	private DbService dbService;

	@GetMapping("get")
	public UserDto getUser(@RequestParam Integer id) throws UserNotFoundException{
		return dbMapper.mapToUserDto(dbService.findById(id).orElseThrow(UserNotFoundException::new));
	}

	@PostMapping("save")
	public void saveUser(@RequestBody UserDto UserDto) {
		dbService.save(dbMapper.mapToUser(UserDto));
	}

	@PutMapping("update")
	public UserDto updateUser(@RequestBody UserDto userDto){
		return dbMapper.mapToUserDto(dbService.save(dbMapper.mapToUser(userDto)));
	}

	@DeleteMapping("delete")
	public void deleteUser(@RequestParam Integer id) throws UserNotFoundException {
		dbService.delete(dbService.findById(id).orElseThrow(UserNotFoundException::new));
	}
}
