package com.example.system.model;

import com.example.system.pojo.ScoreAppeal;
import lombok.*;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScoreExamTeacherDetailModel {
    private String sId;
    private String teId;
    private String saContent;
    private Integer saResult;
    private String saBackContent;
    private String seId;
    private String teContent;
    private String tePicture;
    private String teScore;
    private String sedAnswer;
    private String sedScore;
    private String teAnswer;
}