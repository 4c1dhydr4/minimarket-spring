package com.validations;
import com.modelos.Sale;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SaleValidation implements Validator
{
    @Override
    public boolean supports(Class<?> type) 
    {
        return Sale.class.isAssignableFrom(type);
    }
    
    @Override
    public void validate(Object o, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "SaleDate",
            "required.SaleDate", "El Campo Fecha de Venta es Obligatorio.");
    }
}