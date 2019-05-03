package dev.obsydian.securedaccess.service;

import dev.obsydian.securedaccess.domain.User;
import dev.obsydian.securedaccess.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

	@Autowired
	private DbRepository dbRepository;

	public Optional<User> findById(Integer id){
		return dbRepository.findById(id);
	}

	public List<User> findAll() {
		return dbRepository.findAll();
	}

	public User save(User user) {
		return dbRepository.save(user);
	}

	public void delete(User user){
		dbRepository.delete(user);
	}
}
