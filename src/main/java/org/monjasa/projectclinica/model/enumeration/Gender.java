package org.monjasa.projectclinica.model.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Gender {

    NOT_KNOWN("Not known"),
    MALE("Male"),
    FEMALE("Female"),
    NOT_APPLICABLE("Not applicable");

    @Getter
    private final String designator;
}
