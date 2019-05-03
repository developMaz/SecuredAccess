package dev.obsydian.securedaccess.repository;

import dev.obsydian.securedaccess.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DbRepository extends CrudRepository<User, Integer> {

	Optional<User> findById(Integer id);

	List<User> findAll();

	User save(User user);

	void delete(User user);

}
