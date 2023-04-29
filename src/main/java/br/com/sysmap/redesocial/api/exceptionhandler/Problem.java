package br.com.sysmap.redesocial.api.exceptionhandler;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Problem {
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Properties> properties;
}
