package com.validations;
import com.modelos.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidation implements Validator
{
    @Override
    public boolean supports(Class<?> type) 
    {
        return User.class.isAssignableFrom(type);
    }
    
    @Override
    public void validate(Object o, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
            "required.username", "El Campo Usuario es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
            "required.password", "El Campo Contraseña es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname",
            "required.firstname", "El Campo Nombres es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname",
            "required.lastname", "El Campo Apellidos es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
            "required.email", "El Campo Correo Electrónico es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
            "required.address", "El Campo Dirección de Registro es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone",
            "required.phone", "El Campo Número Telefónico es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "typeUser",
            "required.typeUser", "El Campo Tipo de Usuario es Obligatorio.");
    }
}