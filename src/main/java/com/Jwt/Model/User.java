package com.Jwt.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User
{
    private String userid;
    private String name;
    private String email;
}
