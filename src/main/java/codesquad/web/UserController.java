package codesquad.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import codesquad.dto.UserDto;
import codesquad.service.UserService;

@Controller
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	@GetMapping("/create")
	public String createForm() {
		return "/signUp";
	}

	@PostMapping("/create")
	public String create(UserDto userDto) {
		userService.create(userDto.toUser());
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "/login";
	}
}
