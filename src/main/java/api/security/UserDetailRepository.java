package api.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.domain.User;

@Repository
public interface UserDetailRepository extends JpaRepository<User, Long> {
	public Optional<User> findByEmail(String email);
	public Optional<User> findByUsername(String username);
}
