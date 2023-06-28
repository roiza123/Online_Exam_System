package com.example.system.pojo;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScoreAppeal {
    public String sId;
    public String teId;
    public String saContent;
    public String saResult;
    public String saBackContent;
}