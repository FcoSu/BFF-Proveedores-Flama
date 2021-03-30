package com.everis.latam.BFFProveedoresFlama.Entity;

import lombok.Data;

@Data
public class Solicitud {

	int numero;
	int monto;
	int iva;
	String prioridad;
}
