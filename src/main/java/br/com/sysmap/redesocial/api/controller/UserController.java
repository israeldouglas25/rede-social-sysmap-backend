package br.com.sysmap.redesocial.api.controller;

import br.com.sysmap.redesocial.exception.DomainException;
import br.com.sysmap.redesocial.service.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody UserRequest request) {
        var response = iUserService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(iUserService.getAll());
    }

    @GetMapping("/friends")
    public ResponseEntity<List<UserFriendsResponse>> getAllUser() {
        return ResponseEntity.ok(iUserService.getAllFriends());
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getById(@PathVariable String email) {
        return ResponseEntity.ok(iUserService.getByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @PathVariable UUID id, @RequestBody UserRequest request) {
        iUserService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/follow")
    public ResponseEntity<Void> followUser(@PathVariable UUID userId, @RequestBody UserFollowingRequest request) {
        iUserService.followUser(userId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        iUserService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/photo/update")
    public ResponseEntity uploadPhotoProfile(@RequestParam("photo")MultipartFile photo){
        try {
            iUserService.uploadPhotoProfile(photo);
            return new ResponseEntity(HttpStatus.OK);
        }catch (DomainException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
