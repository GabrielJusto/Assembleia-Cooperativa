package br.con.bonatto.AssembleiaCooperativa.config.vaidacao;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.con.bonatto.AssembleiaCooperativa.modelo.StatusVoto;

public class VotoValidator implements ConstraintValidator<Voto, String>
{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return Arrays.asList(StatusVoto.values()).stream().anyMatch(v -> v.name().equals(value));
	}

	
}
