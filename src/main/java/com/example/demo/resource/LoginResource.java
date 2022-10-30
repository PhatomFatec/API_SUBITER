package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtUtils;
import com.example.demo.security.Login;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginResource {

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping()
	public Login autenticar(@RequestBody Login login) throws JsonProcessingException {
		Authentication auth = new UsernamePasswordAuthenticationToken(login.getName(), login.getSenha());
		auth = authManager.authenticate(auth);
		login.setSenha(null);
		login.setToken(JwtUtils.generateToken(auth));
		login.setAutorizacao(auth.getAuthorities().iterator().next().getAuthority());
		return login;
	}
}