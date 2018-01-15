package codesquad.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import codesquad.AlreadyExistedUserException;
import codesquad.UnAuthenticationException;
import codesquad.domain.User;
import codesquad.domain.UserRepository;

@Service("userService")
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@Resource(name = "userRepository")
	private UserRepository userRepository;

	public void create(User user) {
		Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
		if (optionalUser.isPresent()) {
			throw new AlreadyExistedUserException();
		}
		userRepository.save(user);
	}

	public User login(User user) {
		Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
		if (!optionalUser.isPresent()) {
			throw new UnAuthenticationException();
		}
		User loginUser = optionalUser.get();
		if (!loginUser.matchPassword(user.getPassword())) {
			throw new UnAuthenticationException();
		}
		return loginUser;
	}

}
