package com.studentbooks.student.entities;


import javax.persistence.*;

import com.studentbooks.student.enums.PhoneType;

import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType phoneType;

    @Column(nullable = false, unique = true)
    private String number;
}
