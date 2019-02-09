package com.validations;
import com.modelos.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValidation implements Validator
{
    @Override
    public boolean supports(Class<?> type) 
    {
        return Product.class.isAssignableFrom(type);
    }
    
    @Override
    public void validate(Object o, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ProductCode",
            "required.ProductCode", "El Campo Código de Producto es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ProductName",
            "required.ProductName", "El Campo Nombre de Producto es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "QuantityPerUnit",
            "required.QuantityPerUnit", "El Campo Cantidad por Unidad es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "UnitPrice",
            "required.UnitPrice", "El Campo Precio es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "UnitsInStock",
            "required.UnitsInStock", "El Campo Stock es Obligatorio.");
    }
}