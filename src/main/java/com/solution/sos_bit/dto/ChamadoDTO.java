package com.solution.sos_bit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChamadoDTO {
    private String title;

    public ChamadoDTO() {

    }
    public ChamadoDTO(String title) {
        this.title = title;
    }
}
