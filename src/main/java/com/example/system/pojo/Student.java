package com.example.system.pojo;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    public String sId;
    public String sName;
    public String sPassword;
    public Integer sGrade;
    public String sMajor;
    public Integer sClass;
    public String sSex;
    public String sCollege;
}