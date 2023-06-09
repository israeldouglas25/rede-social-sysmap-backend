package br.com.sysmap.redesocial.data.embedded;

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
