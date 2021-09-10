package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Role;
import com.example.APIBigboss.models.User;
import com.example.APIBigboss.payload.request.LoginRequest;
import com.example.APIBigboss.payload.request.SignupRequest;
import com.example.APIBigboss.payload.response.JwtResponse;
import com.example.APIBigboss.payload.response.MessageResponse;
import com.example.APIBigboss.repository.RoleRepository;
import com.example.APIBigboss.repository.UserRepository;
import com.example.APIBigboss.security.jwt.JwtUtils;
import com.example.APIBigboss.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
   
}

