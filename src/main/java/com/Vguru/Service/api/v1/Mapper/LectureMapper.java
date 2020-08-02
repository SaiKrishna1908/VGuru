package com.Vguru.Service.api.v1.Mapper;

import com.Vguru.Service.api.v1.domainDTO.LectureDTO;
import com.Vguru.Service.model.Lecture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LectureMapper {
    static final LectureMapper INSTANCE  = Mappers.getMapper(LectureMapper.class);

    public LectureDTO lectureTOLectureDTO(Lecture lecture);

}
