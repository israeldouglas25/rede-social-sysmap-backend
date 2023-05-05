package br.com.sysmap.redesocial.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    private UUID userId;
    private UUID postId;
}
