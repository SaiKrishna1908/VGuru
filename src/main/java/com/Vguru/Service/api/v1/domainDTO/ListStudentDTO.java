package com.Vguru.Service.api.v1.domainDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ListStudentDTO {
    List<StudentDTO> studentDTOS = new ArrayList<>();
}
