package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

	public static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@GetMapping("/authenticate")
	@ResponseBody
	public Map<String, String> getToken(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("start Authentication");

		Map<String, String> tokenMap = new HashMap<String, String>();
		
		String user = getUser(authHeader);
		String jwtToken = generateJwt(user);

		tokenMap.put("token", jwtToken);
		LOGGER.info("end Authentication");

		return tokenMap;
	}

	private String getUser(@RequestHeader("Authorization") String authHeader) {
		String encodedCredentials = authHeader.substring(6);
		return new String(Base64.getDecoder().decode(encodedCredentials));
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		return token;
	}

}
