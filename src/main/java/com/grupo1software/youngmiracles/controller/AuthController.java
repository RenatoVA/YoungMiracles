package com.grupo1software.youngmiracles.controller;

import com.grupo1software.youngmiracles.dto.AuthResponseDTO;
import com.grupo1software.youngmiracles.dto.LoginDTO;
import com.grupo1software.youngmiracles.dto.UsuarioDTO;
import com.grupo1software.youngmiracles.service.AdminUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins={"http://localhost:4200/"})
public class AuthController {
    private final AdminUsuarioService adminUsuarioService;

    @PostMapping("/register/usuario")
    public ResponseEntity<UsuarioDTO> registerCustomer(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioDTO1= adminUsuarioService.createUsuarioCustomer(usuarioDTO);
        return new ResponseEntity<>(usuarioDTO1, HttpStatus.CREATED);
    }
    @PostMapping("/register/admin")
    public ResponseEntity<UsuarioDTO> registerAdmin(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioDTO1= adminUsuarioService.createUsuarioAdmin(usuarioDTO);
        return new ResponseEntity<>(usuarioDTO1, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        AuthResponseDTO authResponseDTO = adminUsuarioService.login(loginDTO);
        return new ResponseEntity<>(authResponseDTO, HttpStatus.OK);
    }
}
