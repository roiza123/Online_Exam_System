package com.example.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExamNotChoiceModel {
    private String teId;
    private String teContent;
    private String teType;
    private String teAnswer;
    private Integer teScore;
    private String tePicture;
    private String sedAnswer;
    private Integer sedScore;
    private String seId;
    private String eSubject;
}