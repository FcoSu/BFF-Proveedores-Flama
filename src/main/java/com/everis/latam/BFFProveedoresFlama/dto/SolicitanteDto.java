package com.everis.latam.BFFProveedoresFlama.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SolicitanteDto {

	String nombreSolicitante;
	String cargo;
	int idAprovador;
	String Aprovador;
	
}
