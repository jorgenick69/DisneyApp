

package com.AlkemyChallenge.Disney.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiErrorDTO {
    private HttpStatus status;
    private String menssage;
    private List<String>errors;
}
