package codesquad.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	@GetMapping("/create")
	public String createForm() {
		return "/signUp";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginedUser");
		return "redirect:/";
	}
}
