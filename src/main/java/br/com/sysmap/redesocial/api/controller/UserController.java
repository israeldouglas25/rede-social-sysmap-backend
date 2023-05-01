package br.com.sysmap.redesocial.api.controller;

import br.com.sysmap.redesocial.service.user.IUserService;
import br.com.sysmap.redesocial.service.user.UserRequest;
import br.com.sysmap.redesocial.service.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserRequest request) {
        var response = iUserService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(iUserService.getAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getById(@PathVariable String email) {
        return ResponseEntity.ok(iUserService.getByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody UserRequest request) {
        iUserService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        iUserService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
