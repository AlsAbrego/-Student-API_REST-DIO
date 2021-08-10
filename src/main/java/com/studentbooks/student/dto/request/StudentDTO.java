package com.studentbooks.student.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.studentbooks.student.entities.Address;

import lombok.*;

import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;
    

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;


    @NotNull
    private String birthday;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    @Valid
    @NotEmpty
    private List<AddressDTO> addresses;
    
}
