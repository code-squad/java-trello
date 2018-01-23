package codesquad.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import codesquad.service.MemberService;

@Controller
public class MyBoardsController {
	private static final Logger log = LoggerFactory.getLogger(MyBoardsController.class);
	@Resource(name = "memberService")
	private MemberService memberService;

	@GetMapping("/myboards")
	public String board(Authentication authentication, Model model) {
		log.debug("requested user's username is : {}" , authentication.getName());
		model.addAttribute("boards", memberService.getBoardsByEmail(authentication.getName()));
		return "/boards";
	}
}
