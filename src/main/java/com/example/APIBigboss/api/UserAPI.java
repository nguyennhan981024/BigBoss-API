package com.example.APIBigboss.api;

import com.example.APIBigboss.dto.UserDTO;
import com.example.APIBigboss.models.Role;
import com.example.APIBigboss.models.User;
import com.example.APIBigboss.repository.RoleRepository;
import com.example.APIBigboss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/user")
public class UserAPI {

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_MANAGER = "ROLE_MANAGER";
    private static final String ROLE_USER = "ROLE_USER";


    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping //read data
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable int id) {
        Optional<User> optionalUser = userRepository.findUserByID(id);
        if (!optionalUser.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalUser.get());
    }

    @PostMapping("update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @Valid @RequestBody UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findUserByID(id);
        if (!optionalUser.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        User user = new User(userDTO.getUsername(),
                userDTO.getEmail(),
                encoder.encode(userDTO.getPassword()));

        Set<String> strRoles = userDTO.getRoles();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByRoleName(ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByRoleName(ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "user":
                        Role userRole = roleRepository.findByRoleName(ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                        break;
                    default:
                        Role managerRole = roleRepository.findByRoleName(ROLE_MANAGER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(managerRole);
                }
            });
        }
        user.setRoles(roles);
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setUserID(optionalUser.get().getUserID());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAddress(userDTO.getAddress());
        user.setHeight(userDTO.getHeight());
        user.setMale(userDTO.getMale());
        user.setWeight(userDTO.getWeight());
        user.setImg(userDTO.getImg());
        userRepository.save(user);
        return ResponseEntity.ok(optionalUser.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        Optional<User> optionalUser = userRepository.findUserByID(id);

        if (!optionalUser.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        userRepository.delete(optionalUser.get());
        return ResponseEntity.noContent().build();
    }
}