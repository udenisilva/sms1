package com.lk.std.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.lk.std.model.SystemUser;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

  private AuthenticationSuccessHandler target = new SavedRequestAwareAuthenticationSuccessHandler();

  public LoginSuccessHandler() {}

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    System.out.println("CAME HERE onAuthenticationSuccess");
    if (authentication != null) {
      Object principal = authentication.getPrincipal();
      UserDetails userDetails = (UserDetails) (principal instanceof UserDetails ? principal : null);
      // If the user has logged in
      if (userDetails != null) {
        try {
          SystemUser systemUser = (SystemUser) userDetails;
          HttpSession session = request.getSession();

          System.out.println("user logged :" + systemUser.getUserName());
          for (GrantedAuthority userRole : systemUser.getAuthorities()) {
            System.out.println("user has role" + userRole.toString());
          }

          session.setAttribute("SESSION_USER", systemUser);
          session.setAttribute("SESSION_USER_ID", systemUser.getUserId());
          session.setAttribute("SESSION_USER_DISPLAY_NAME", systemUser.getUserDisplayName());
          session.setAttribute("SESSION_APP_CERTIFY_USER", systemUser.getUserRoles().get(0).isCertifyStatus());
//          session.setAttribute("SESSION_APP_LANG", "en");

          System.out.println("systemUser.getUserRoles().get(0).isCertifyStatus() -----------------   "
              + systemUser.getUserRoles().get(0).isCertifyStatus());

          // otherwise send to the default location from front end
          target.onAuthenticationSuccess(request, response, authentication);

        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }



  }
}
