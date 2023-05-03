package br.com.sysmap.redesocial.api.controller;

import br.com.sysmap.redesocial.service.post.IPostService;
import br.com.sysmap.redesocial.service.post.PostRequest;
import br.com.sysmap.redesocial.service.post.PostResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private IPostService iPostService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody PostRequest request) {
        var postResponse = iPostService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(postResponse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PostResponse>> getAllByUser(@PathVariable UUID userId){
        return ResponseEntity.ok(iPostService.getAllByUser(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        iPostService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
