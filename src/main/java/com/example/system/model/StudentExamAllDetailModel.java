package com.example.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExamAllDetailModel {

    private String seId;
    private String teId;
    private String teContent;
    private String tePicture;
    private String teScore;
    private String sedAnswer;
    private String sedScore;
    private String teAnswer;
}