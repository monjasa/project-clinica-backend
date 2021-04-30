package org.monjasa.projectclinica.util.converter;

import org.monjasa.projectclinica.model.enumeration.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender attribute) {
        return Optional.ofNullable(attribute)
                .map(Gender::getDesignator)
                .orElse(null);
    }

    @Override
    public Gender convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData)
                .map(Gender::valueOf)
                .orElse(null);
    }
}
