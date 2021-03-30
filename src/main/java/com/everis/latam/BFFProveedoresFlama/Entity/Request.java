package com.everis.latam.BFFProveedoresFlama.Entity;


import lombok.Data;

@Data
public class Request {

	   private Proveedor proveedor;
	   private Area area;
	   private Solicitante solicitante;
	   private Solicitud solicitud;
	   private String descripcion;
}
