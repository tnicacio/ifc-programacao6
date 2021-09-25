package com.tnicacio.paypayapi.dto;

import com.tnicacio.paypayapi.user.service.validation.UserInsertValid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@UserInsertValid
public class UserInputDTO extends UserDTO {
    private static final long serialVersionUID = 1L;

    private String password;

    public UserInputDTO() {
        super();
    }

}
