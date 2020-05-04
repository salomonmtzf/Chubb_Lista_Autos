
package com.codigochubb.modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UsuariosValidar implements Validator {
    
    private Pattern pattern;
    private Matcher matcher;
    
    @Override
    public boolean supports(Class<?> type) 
    {
    return Autos.class.isAssignableFrom(type);    
    //return TuClase.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
     Autos usuarios=(Autos)o;
     ValidationUtils.rejectIfEmptyOrWhitespace
                    (errors, 
                    "marca",
                    "required.marca",
                    "El campo marca es obligatorio"
                    );
     ValidationUtils.rejectIfEmptyOrWhitespace
                    (errors, 
                    "cantidad",
                    "required.cantidad",
                    "El campo cantidad es obligatorio."
                    );
      ValidationUtils.rejectIfEmptyOrWhitespace
                    (errors, 
                    "inventario",
                    "required.inventario",
                    "El campo código inventario es obligatorio"
                    );
 
        }
}
     

     
     
   
    
   