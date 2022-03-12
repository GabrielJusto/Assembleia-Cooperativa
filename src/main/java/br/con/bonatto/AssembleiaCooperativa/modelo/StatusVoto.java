package br.con.bonatto.AssembleiaCooperativa.modelo;

import java.util.Arrays;

public enum StatusVoto {

	SIM,
	NAO;
	
	
	public static StatusVoto parseStatusVoto (String valor)
	{
		return Arrays.asList(StatusVoto.values()).stream().filter(s -> s.name().equals(valor)).findFirst().get();
	}
}
