package com.Vguru.Service.api.v1.domainDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ListCourseDTO {

    private List<CourseDTO> courseDTOS = new ArrayList<>();
}


//Post