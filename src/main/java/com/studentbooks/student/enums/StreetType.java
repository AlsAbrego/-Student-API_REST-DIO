package com.studentbooks.student.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StreetType {
    STREET("Street"),
    AVENUE("Avenue"),
    ROAD("Road"),
    BOULEVARD("Boulevard"),
    BYWAY("Byway"),
    OTHER("Other");

    private final String description;
}
