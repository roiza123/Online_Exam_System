package com.example.system.pojo;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exam {
    public String eId;
    public String tId;
    public String eSubject;
    public Date eBegin;
    public Date eEnd;
}