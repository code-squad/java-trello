package codesquad.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.domain.Members;
import codesquad.domain.MembersRepository;
import codesquad.domain.User;
import codesquad.domain.UserRepository;

@Service("membersService")
public class MembersService {
	@Resource(name = "membersRepository")
	private MembersRepository membersRepository;
	@Resource(name = "userRepository")
	private UserRepository userRepository;

	public Members create(long userId) {
		User user = userRepository.getOne(userId);
		Members members = membersRepository.save(new Members(user));
//		user.addGroup(group);
		return members;
	}

	public Members create(User user) {
		Members members = membersRepository.save(new Members(user));
//		user.addGroup(group);
		return members;
	}

}
