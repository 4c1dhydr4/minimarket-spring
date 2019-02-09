package com.validations;
import com.modelos.Client;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ClientValidation implements Validator
{
    @Override
    public boolean supports(Class<?> type) 
    {
        return Client.class.isAssignableFrom(type);
    }
    
    @Override
    public void validate(Object o, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ClientCode",
            "required.ClientCode", "El Campo Código de Cliente es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "FirstName",
            "required.FirstName", "El Campo Nombres es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "LastName",
            "required.LastName", "El Campo Apellidos es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "RegisterDate",
            "required.RegisterDate", "El Campo Fecha de Registro es Obligatorio.");
    }
}