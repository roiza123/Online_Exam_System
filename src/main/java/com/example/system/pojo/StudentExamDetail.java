package com.example.system.pojo;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentExamDetail {
    public String seId;
    public String teId;
    public String sedAnswer;
    public Integer sedScore;
    public String tId;
}