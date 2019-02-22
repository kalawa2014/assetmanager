package com.sfeir.graph.assetmanager.reference.service;

import com.sfeir.graph.assetmanager.reference.repository.UserRepository;
import com.sfeir.graph.assetmanager.reference.user.AppUserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
@Slf4j
public class AuthenticationSuccessHandlerImpl  implements AuthenticationSuccessHandler {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Environment env;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();



	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2) throws IOException, ServletException {

		userRepository.updateLastLogin(new Date(),((AppUserPrincipal)arg2).getUsername());
		try {
			handle(arg0, arg1);
		} catch (IOException e) {
			log.debug("{}",e);
		}
	}

	private void handle(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		final String targetUrl = env.getProperty("backend.graph") + "/graphs";

		if (response.isCommitted()) {
			log.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
}
