package com.everis.latam.BFFProveedoresFlama.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProveedorDto {
	
	int idProveedor; 
	String nombre;
	String razonSocial;
	String rut;
	String email;
	
	
}
