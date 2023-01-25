package com.okta.developer.ADP_Capstone.AppUser.Security.jwt;

import com.okta.developer.ADP_Capstone.AppUser.Security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
/*This class has 3 main functions:

        getJwtFromCookies: get JWT from Cookies by Cookie name
        generateJwtCookie: generate a Cookie containing JWT from username, date, expiration, secret
        getCleanJwtCookie: return Cookie with null value (used for clean Cookie)
        getUserNameFromJwtToken: get username from JWT
        validateJwtToken: validate a JWT with a secret
        */
@Component
public class JwtUtils implements Serializable {
    //@Serial
    private static final long serialVersionUID = -2_550_185_165_626_007_488L;
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${capstoneApi.jwtSecret}")
    private String jwtSecret;

    @Value("${capstoneApi.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${capstoneApi.jwtCookieName}")
    private String jwtCookie;

 public String generateJwtToken(Authentication authentication) {

     UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

     return Jwts.builder()
             .setSubject(String.valueOf(userPrincipal))
             .setIssuedAt(new Date(System.currentTimeMillis()))
             .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
             .signWith(SignatureAlgorithm.HS512, jwtSecret)
             .compact();
 }
    //retrieve username from jwt token
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
    /*public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    //generate cookie from username
    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/capstoneApi")
                .maxAge(24 * 60 * 60).httpOnly(true).build();
        return cookie;
    }
//
    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/capstoneApi").build();
        return cookie;
    }

*/
    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}