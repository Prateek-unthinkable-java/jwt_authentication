package developer.prateek.jwt_authentication.controller;

import developer.prateek.jwt_authentication.exception.BadCredentialException;
import developer.prateek.jwt_authentication.helper.JwtUtil;
import developer.prateek.jwt_authentication.model.JWTRequest;
import developer.prateek.jwt_authentication.model.JWTResponse;
import developer.prateek.jwt_authentication.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JWTController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/generateToken")
    public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest);
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtRequest.getUsername(), jwtRequest.getPassword()));

        } catch (UsernameNotFoundException u) {
            u.printStackTrace();
            throw new Exception("Bad credentials");
        } catch (BadCredentialsException b) {
            b.printStackTrace();
            throw new BadCredentialException("Credential doesn't match.");
        }

        UserDetails userDetails = customUserDetailService.loadUserByUsername(jwtRequest.getUsername());

        String token = jwtUtil.generateToken(userDetails);
        System.out.println("Token: "+token);

        return ResponseEntity.ok(new JWTResponse(token));
    }
}
