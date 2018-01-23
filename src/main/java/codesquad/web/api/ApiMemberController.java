package codesquad.web.api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codesquad.dto.MemberDto;
import codesquad.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class ApiMemberController {
	private static final Logger log = LoggerFactory.getLogger(ApiMemberController.class);
	
	@Resource(name="memberService")
	private MemberService memberService;

	@Resource(name="passwordEncoder")
	private BCryptPasswordEncoder passwordEncoder;


	@PostMapping("")
	public ResponseEntity<Void> create(@RequestBody MemberDto memberDto){
		log.debug("memberDto : {}", memberDto);
		String encryptPassword = passwordEncoder.encode(memberDto.getPassword());
		memberDto.setPassword(encryptPassword);
		memberService.create(memberDto.toMember());
		return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
	}
	
}
