package com.tamil.quizApp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalResponseDTO {
    private String message;
    private Boolean status;
    private Object data;
}
