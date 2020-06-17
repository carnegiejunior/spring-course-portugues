package springcourse.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import springcourse.domain.User;
import springcourse.exceptions.NotFoundException;
import springcourse.repository.UserRepository;

@Component("accessManager")
public class AccessManager {
	
	@Autowired
	UserRepository userRepository;
	

	public boolean isOwner(Long id) {
		String username = SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal().toString();
		
		Optional<User> user = this.userRepository.findUserByEmail(username);

		if (!user.isPresent()) throw new NotFoundException("There are not user with id = "+username);
		return user.get().getId().equals(id);
	}
	
	
	public boolean isRequestOwner(Long id) {
		
		return false;
	}
	
}