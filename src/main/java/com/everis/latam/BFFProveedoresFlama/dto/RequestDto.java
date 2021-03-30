package com.everis.latam.BFFProveedoresFlama.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestDto {
	
	   private ProveedorDto proveedor;
	   private AreaDto area;
	   private SolicitanteDto solicitante;
	   private SolicitudDto solicitud;
	   private String descripcion;

}
