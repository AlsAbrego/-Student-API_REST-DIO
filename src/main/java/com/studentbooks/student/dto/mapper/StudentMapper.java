package com.studentbooks.student.dto.mapper;

// import java.time.LocalDate;

import com.studentbooks.student.dto.request.StudentDTO;
import com.studentbooks.student.entities.Student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
// import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    //Mapping the birthday from Student Entity
    @Mapping(source = "birthday", target = "birthday", dateFormat = "dd-MM-yyyy")

    Student toModel(StudentDTO dto);

    StudentDTO toDTO(Student dto);    
    
    
    /*Just the Student was mapped, 
    so when one boot the project the warning for Phone and Address not mapped will rise */
}



