package dev.obsydian.securedaccess.repository;

import dev.obsydian.securedaccess.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);
	User save(User user);

}
