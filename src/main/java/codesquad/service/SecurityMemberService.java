package codesquad.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import codesquad.UnAuthenticationException;
import codesquad.domain.Member;
import codesquad.domain.SecurityMember;
import codesquad.domain.repository.MemberRepository;

@Service("securityMemberService")
public class SecurityMemberService implements UserDetailsService{
	private static final Logger log = LoggerFactory.getLogger(SecurityMemberService.class);

	
	@Resource(name="memberRepository")
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("security username : {}", username);
		Member member = memberRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("아이디 혹은 비밀번호를 잘 못 입력 하셨습니다."));
		log.debug("security member : {}" , member);
		return new SecurityMember(member);
	}

}
