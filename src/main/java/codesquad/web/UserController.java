package codesquad.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/create")
	public String createForm() {
		return "/signUp";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "/login";
	}
}
