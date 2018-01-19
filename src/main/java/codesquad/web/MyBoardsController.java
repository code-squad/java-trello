package codesquad.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import codesquad.domain.Member;
import codesquad.security.LoginUser;
import codesquad.service.MemberService;

@Controller
public class MyBoardsController {
	private static final Logger log = LoggerFactory.getLogger(MyBoardsController.class);
	@Resource(name = "memberService")
	private MemberService memberService;

	@GetMapping("/myboards")
	public String board(@LoginUser Member member, Model model) {
		model.addAttribute("boards", memberService.getBoards(member));
		return "/boards";
	}
}
