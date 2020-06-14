package springcourse.security;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtManager {
	public String createToken(String email, List<String> roles) {
		
		Calendar expirationTime = Calendar.getInstance();
		expirationTime.add(Calendar.DAY_OF_MONTH, SecurityConstants.JWT_EXP_DAYS);
		 
		String jwt = Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationTime.getTime())
				.claim(SecurityConstants.JWT_ROLE_KEY,roles)
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.API_KEY.getBytes())
				.compact();
		
		return jwt;
	}
}
