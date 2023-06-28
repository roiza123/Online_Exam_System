package com.example.system.pojo;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentExam {
    public String seId;
    public String sId;
    public String eId;
    public Integer choiceScore;
    public Integer correctScore;
}