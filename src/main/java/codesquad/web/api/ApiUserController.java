package codesquad.web.api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codesquad.dto.UserDto;
import codesquad.service.UserService;

@RestController
@RequestMapping("/api/users")
public class ApiUserController {
	private static final Logger log = LoggerFactory.getLogger(ApiUserController.class);
	
	@Resource(name="userService")
	private UserService userService;
	
	@PostMapping("")
	public ResponseEntity<Void> create(@RequestBody UserDto userDto){
		userService.create(userDto.toUser());
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
}
