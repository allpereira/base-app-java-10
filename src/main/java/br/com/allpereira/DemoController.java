package br.com.allpereira;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;

@RestController
public class DemoController {
	private final String version;

	public DemoController(@Value("${java.version}") String version) {
		this.version = version;
	}

	@GetMapping("/")
	String index() {
		if (StringUtils.hasText(this.version)) {
			return "Hello World! <br /> I'm running in Java " + this.version + " version.";
		} else {
			return "Hello World!";
		}
	}
}