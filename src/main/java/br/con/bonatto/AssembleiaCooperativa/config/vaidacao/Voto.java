package br.con.bonatto.AssembleiaCooperativa.config.vaidacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {VotoValidator.class })
public @interface Voto 
{
	String message() default "Valor de voto inválido";
	
	  Class<? extends Payload>[] payload() default {};

	  Class<?>[] groups() default {};
}
