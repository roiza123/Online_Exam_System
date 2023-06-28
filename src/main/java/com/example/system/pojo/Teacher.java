package com.example.system.pojo;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
    public String tId;
    public String tName;
    public String tPassword;
    public String tPhone;
    public String tRole;
    public String ifDelete;

}