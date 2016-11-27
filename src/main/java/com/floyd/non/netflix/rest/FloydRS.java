package com.floyd.non.netflix.rest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FloydRS {

	@RequestMapping("/")
	public String index() {
		return 
				new StringBuilder("\"Hey You!!\" - David Gilmour")
					.append("\n \"High Hopes\" -- David Gilmour")
					.toString();
	}

	@RequestMapping(value = "/dark-side-of-the-moon", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InputStreamResource> showLogo() throws IOException {
	    URL url = new URL("http://i.ytimg.com/vi/NJQnzmH6jgc/maxresdefault.jpg");
	    URLConnection conn = url.openConnection();
	    
	    return ResponseEntity.ok()
	            .contentLength(2048*2048)
	            .contentType(MediaType.IMAGE_JPEG)
	            .body(new InputStreamResource(conn.getInputStream()));
	}

}
