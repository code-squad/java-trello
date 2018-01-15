package codesquad.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.domain.Member;
import codesquad.domain.MemberRepository;
import codesquad.domain.User;
import codesquad.domain.UserRepository;

@Service("memberService")
public class MemberService {
	@Resource(name = "memberRepository")
	private MemberRepository memberRepository;
	@Resource(name = "userRepository")
	private UserRepository userRepository;

	public Member create(long userId) {
		User user = userRepository.getOne(userId);
		Member member = memberRepository.save(new Member(user));
		user.addMember(member);
		return member;
	}

}
