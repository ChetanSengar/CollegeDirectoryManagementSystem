package dev.jagan.college_directory_management_system.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final SecretKey secretKey = Keys.hmacShaKeyFor("your-secret-key-here".getBytes(StandardCharsets.UTF_8));

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain) throws IOException, ServletException {
        final String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            final String token = authorizationHeader.substring(7);

            try {
                final Jws<Claims> claimsJws = Jwts.parser()
                        .setSigningKey(secretKey)
                        .build()
                        .parseClaimsJws(token);

                final String username = claimsJws.getBody().getSubject();
                if (username != null) {
                    final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            username, null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));  // Adjust roles as necessary
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (final JwtException e) {
                throw new RuntimeException("Expired or invalid JWT token");
            }
        }

        filterChain.doFilter(request, response);
    }
}