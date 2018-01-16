package codesquad.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import codesquad.AlreadyExistedUserException;
import codesquad.UnAuthenticationException;
import codesquad.domain.Board;
import codesquad.domain.User;
import codesquad.domain.UserRepository;

@Service("userService")
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@Resource(name = "userRepository")
	private UserRepository userRepository;
	
	public User getDbUser(User user) {
		return userRepository.getOne(user.getId());
	}

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

	public void addBoard(User user, Board board) {
		user.addBoard(board);
		userRepository.save(user);
	}

	public List<Board> getBoards(User user) {
		user = userRepository.getOne(user.getId());
		return user.getBoardList();
	}

}
