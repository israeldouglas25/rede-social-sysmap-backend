package br.com.sysmap.redesocial.api.controller;

import br.com.sysmap.redesocial.service.user.*;
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
    public ResponseEntity<String> create(@RequestBody CreateUserRequest request){
        var response = iUserService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<GetAllUsersRequest>> getAll(){
        return ResponseEntity.ok(iUserService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserByRequest> getById(@PathVariable UUID id){
        return ResponseEntity.ok(iUserService.getById(id));
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable UUID id, @RequestBody CreateUserRequest request){
        return ResponseEntity.ok(iUserService.update(id, request));
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        iUserService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
