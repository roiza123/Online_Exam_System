package com.example.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScoreListModel {
    private String sId;
    private String eId;
    private String eSubject;
    private Integer eAllScore;
    private Integer eRank;
    private String seId;

}