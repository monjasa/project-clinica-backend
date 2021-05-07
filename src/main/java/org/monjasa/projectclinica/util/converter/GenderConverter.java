package org.monjasa.projectclinica.util.converter;

import org.monjasa.projectclinica.model.enumeration.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return Optional.ofNullable(gender)
                .map(Gender::getDesignation)
                .orElse(null);
    }

    @Override
    public Gender convertToEntityAttribute(String genderDesignation) {
        return Optional.ofNullable(genderDesignation)
                .map(Gender::valueOf)
                .orElse(null);
    }
}
