package com.studentbooks.student.entities;

import javax.persistence.*;

import com.studentbooks.student.enums.AddressType;
import com.studentbooks.student.enums.StreetType;

import lombok.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AddressType adrresType;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String administrativeArea;

    @Column(nullable = false)
    private String locality;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StreetType  streeType;

    @Column(nullable = false)
    private String number;    
}
