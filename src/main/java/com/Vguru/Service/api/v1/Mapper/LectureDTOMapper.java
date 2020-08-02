package com.Vguru.Service.api.v1.Mapper;

import com.Vguru.Service.api.v1.domainDTO.LectureDTO;
import com.Vguru.Service.model.Lecture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LectureDTOMapper {

    static final LectureDTOMapper INSTANCE = Mappers.getMapper(LectureDTOMapper.class);

    Lecture LectureDTOToLecture(LectureDTO lectureDTO);
}
