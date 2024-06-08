package com.bjtu.commons.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class QueryMovieDataDTO {
    private Integer pageNo = 1;
    private Integer pageSize = 5;
    @NotBlank
    private String company;
    private String sort = "popularity";
}
