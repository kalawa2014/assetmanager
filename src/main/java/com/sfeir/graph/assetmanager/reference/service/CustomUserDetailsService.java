package com.sfeir.graph.assetmanager.reference.service;

import com.sfeir.graph.assetmanager.reference.repository.UserRepository;
import com.sfeir.graph.assetmanager.reference.user.AppUser;
import com.sfeir.graph.assetmanager.reference.user.AppUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private WebApplicationContext applicationContext;
	private UserRepository userRepository;

	public CustomUserDetailsService() {
		super();
	}

	@PostConstruct
	public void completeSetup() {
		userRepository = applicationContext.getBean(UserRepository.class);
	}

	@Override
	public UserDetails loadUserByUsername(final String username) {
		final AppUser appUser = userRepository.findByUsername(username);
		if (appUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new AppUserPrincipal(appUser);
	}

}
