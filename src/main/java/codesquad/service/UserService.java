package codesquad.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.UnAuthenticationException;
import codesquad.domain.User;
import codesquad.domain.UserRepository;

@Service("userService")
public class UserService {
	@Resource(name = "userRepository")
	private UserRepository userRepository;

	public void create(User user) {
		// TODO 아래와 같은 로직을 추가 할지 Restful API 형태로 변경 할 때 고민해 보자
		// Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
		// if (optionalUser.isPresent()) {
		// throw new AlreadyExistedUserException();
		// }
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
