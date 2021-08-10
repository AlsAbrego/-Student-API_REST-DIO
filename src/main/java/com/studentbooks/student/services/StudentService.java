package com.studentbooks.student.services;

import java.util.List;
import java.util.stream.Collectors;

import com.studentbooks.student.dto.mapper.StudentMapper;
import com.studentbooks.student.dto.request.StudentDTO;
import com.studentbooks.student.dto.response.MessageResponseDTO;
import com.studentbooks.student.entities.Student;
import com.studentbooks.student.exception.StudentNotFoundException;
import com.studentbooks.student.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;    


    public MessageResponseDTO create(StudentDTO studentDTO) {
        Student  student = studentMapper.toModel(studentDTO);
        Student savedStudent = studentRepository.save(student);

        MessageResponseDTO messageResponseDTO = createMessageResponse( "Student Created with sucess, with ID: ", savedStudent.getId());

        return messageResponseDTO;
    }
   

   public List<StudentDTO> findAll() {
        List<Student>  students = studentRepository.findAll();
        return students.stream().map(studentMapper::toDTO).collect(Collectors.toList());
    }

    
    public StudentDTO findById(Long id) throws StudentNotFoundException{
        Student studentFind = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        return studentMapper.toDTO(studentFind);
    }

    public String delete(Long id) throws StudentNotFoundException {
        studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.deleteById(id); 
        return "Student with ID: " + id +  " was deleted with success";              
    }

    public MessageResponseDTO update(Long id, StudentDTO studentDTO) throws StudentNotFoundException {
        studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        Student updateStudent = studentMapper.toModel(studentDTO);
        Student savedStudent = studentRepository.save(updateStudent);
        
        MessageResponseDTO messageResponseDTO = createMessageResponse( "Student Created with sucess, with ID: ", savedStudent.getId());
        return messageResponseDTO;
    }

    private MessageResponseDTO createMessageResponse(String string, Long id) {
        return MessageResponseDTO.builder()
                .message(string + id)
                .build();
    }
    
}
