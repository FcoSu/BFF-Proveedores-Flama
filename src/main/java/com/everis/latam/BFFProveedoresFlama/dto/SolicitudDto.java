package com.everis.latam.BFFProveedoresFlama.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SolicitudDto {
	
	int numero;
	int monto;
	int iva;
	String prioridad;
}
