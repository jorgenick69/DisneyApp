package com.AlkemyChallenge.Disney.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
   @Email(message = "username must be an email") 
   private String username;
   @Size(min = 8,message = "the minimum of characters must be 8")
   private String password;
   
}
