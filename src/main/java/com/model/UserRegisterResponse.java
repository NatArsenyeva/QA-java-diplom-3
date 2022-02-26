package com.model;
import com.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterResponse {
      private boolean success;
       private String accessToken;
       private String refreshToken;
       private User user;

}
