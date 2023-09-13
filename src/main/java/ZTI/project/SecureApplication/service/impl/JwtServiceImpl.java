package ZTI.project.SecureApplication.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ZTI.project.SecureApplication.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 *  Service responsible for JWT token handling
 */
@Service
public class JwtServiceImpl implements JwtService {
//    @Value("${token.signing.key}")
    private String jwtSigningKey = "ivmOAxESX/YlLCNIEZIcHOOL9u7pXFnsmhPpKriLP1yywL6SeDSjgsGrTGWGr/oI";

    /**
     * Extract Subject from JWT token. In our case subject is user's email
     * @param token JWT token
     * @return email address of user
     */
    @Override
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Generate token without Extra Claims
     * @param userDetails UserDetails object
     * @return JWT token
     */
    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Check if JWT token contains user's email and if the token is not expired
     * @param userDetails UserDetails object
     * @return bool if JWT token contains user's email and if the token is not expired
     */
    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Return JWT token Claim like subject or expiration time
     * @param token JWT token
     * @param claimsResolvers claimsResolver function like getSubject or getExpiration
     * @return based on a function it can return JWT token subject, token or more
     */
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    /**
     * Generate JWT token for a user with a subject and expiration time
     * @param extraClaims additional claims, in our case empty
     * @param userDetails user details to be shared in JWT token
     * @return JWT token
     */
    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    /**
     * Check if JWT token expiration time is not reached yet
     * @param token JWT token
     * @return JWT token
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Get expiration time from JWT token
     * @param token JWT token
     * @return Date object with expiration time
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extract all claims from JWT token
     * @param token JWT token
     * @return claims from JWT token
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token)
                .getBody();
    }

    /**
     * Get signing key for a JWT token
     * @return Key that is used for creating and reading from JWT token
     */
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
