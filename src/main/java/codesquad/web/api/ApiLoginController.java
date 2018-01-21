package codesquad.web.api;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codesquad.dto.MemberDto;
import codesquad.service.MemberService;

@RestController
@RequestMapping("/api/login")
public class ApiLoginController {
	private static final Logger log = LoggerFactory.getLogger(ApiLoginController.class);
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	@PostMapping("")
	public ResponseEntity<Void> login(@RequestBody MemberDto memberDto, HttpSession session) {
		session.setAttribute("loginedUser", memberService.login(memberDto.toMember()));
		return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.OK);
	}

}
