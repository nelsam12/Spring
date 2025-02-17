package sn.ism.auchan.utils.validators.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.repository.ClientRepository;
import sn.ism.auchan.utils.validators.ListNotEmpty;
import sn.ism.auchan.utils.validators.TelephoneUnique;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TelephoneUniqueValidator implements ConstraintValidator<TelephoneUnique, String> {

    private final ClientRepository clientRepository;
    @Override
    public boolean isValid(String tel, ConstraintValidatorContext constraintValidatorContext) {
        var client = clientRepository.findByTelephone(tel).orElse(null);
        return client == null;
    }
}
