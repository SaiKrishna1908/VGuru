package com.Vguru.Service.model;


import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserInfo implements Serializable {

    private Long id;
    private String email;
    private String username;

}
