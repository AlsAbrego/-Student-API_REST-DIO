package com.studentbooks.student.dto.request;



import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.studentbooks.student.enums.AddressType;
import com.studentbooks.student.enums.StreetType;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String country;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String administrativeArea;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String locality;

    @Enumerated(EnumType.STRING)
    private StreetType  streeType;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String number;    
}
