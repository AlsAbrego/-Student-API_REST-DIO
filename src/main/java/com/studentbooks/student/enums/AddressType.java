package com.studentbooks.student.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressType {
    PERSONAL("Personal"),
    COMERCIAL("Commercial");   
  
    private final String description;
}
