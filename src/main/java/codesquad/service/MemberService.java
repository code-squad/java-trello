package codesquad.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.AlreadyExistedMemberException;
import codesquad.UnAuthenticationException;
import codesquad.domain.Board;
import codesquad.domain.Member;
import codesquad.domain.repository.MemberRepository;

@Service("memberService")
public class MemberService {
	
	@Resource(name = "memberRepository")
	private MemberRepository memberRepository;

	public Member getDbMember(Member member) {
		return memberRepository.getOne(member.getId());
	}

	public void create(Member member) {
		if (memberRepository.findByEmail(member.getEmail()).isPresent()) {
			throw new AlreadyExistedMemberException();
		}
		memberRepository.save(member);
	}

	public Member login(Member member) {
		Member loginUser = memberRepository.findByEmail(member.getEmail()).orElseThrow(UnAuthenticationException::new);
		if (!loginUser.matchPassword(member.getPassword())) {
			throw new UnAuthenticationException();
		}
		return loginUser;
	}

	public void addBoard(Member member, Board board) {
		member.addBoard(board);
		memberRepository.save(member);
	}

	public List<Board> getBoards(Member member) {
		member = memberRepository.getOne(member.getId());
		return member.getBoardList();
	}

	public Object getBoardsByEmail(String email) {
		Member member = memberRepository.findByEmail(email).orElseThrow(UnAuthenticationException::new);
		return member.getBoardList();
	}

	public Member getDbMemberByEmail(String email) {
		return memberRepository.findByEmail(email).orElseThrow(UnAuthenticationException::new);
	}

}
