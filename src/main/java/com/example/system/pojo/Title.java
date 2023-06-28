package com.example.system.pojo;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Title {
    public String teId;
    public String tId;
    public String teContent;
    public String tePicture;
    public String teType;
    public String teAnswer;
    public Integer teScore;
    public String ifDelete;
}