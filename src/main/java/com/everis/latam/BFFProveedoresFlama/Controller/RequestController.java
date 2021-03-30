package com.everis.latam.BFFProveedoresFlama.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.latam.BFFProveedoresFlama.Entity.Response;
import com.everis.latam.BFFProveedoresFlama.Entity.Solicitante;
import com.everis.latam.BFFProveedoresFlama.Entity.Solicitud;
import com.everis.latam.BFFProveedoresFlama.Exception.BadRequestException;
import com.everis.latam.BFFProveedoresFlama.Exception.ExceptionPost;
import com.everis.latam.BFFProveedoresFlama.Entity.Area;
import com.everis.latam.BFFProveedoresFlama.Entity.Proveedor;
import com.everis.latam.BFFProveedoresFlama.Entity.Request;
import com.everis.latam.BFFProveedoresFlama.URLs.URLs;
import com.everis.latam.BFFProveedoresFlama.dto.AreaDto;
import com.everis.latam.BFFProveedoresFlama.dto.ProveedorDto;
import com.everis.latam.BFFProveedoresFlama.dto.RequestDto;
import com.everis.latam.BFFProveedoresFlama.dto.SolicitanteDto;
import com.everis.latam.BFFProveedoresFlama.dto.SolicitudDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class RequestController {
	private HttpHeaders headers = new HttpHeaders();
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = URLs.inputURL, method = RequestMethod.POST)
	public ResponseEntity<Response> sendRequest(@RequestBody Request req, Proveedor prov, Area ar, Solicitante soli, Solicitud solic) throws BadRequestException{
		ProveedorDto proveedorDto = new ProveedorDto(prov.getIdProveedor(), prov.getNombre(), prov.getRazonSocial(), prov.getRut(), prov.getEmail());
		AreaDto areaDto = new AreaDto(ar.getNombreArea(),ar.getResponsable(),ar.getEmail(),ar.getCeco());
		SolicitanteDto solicitanteDto = new SolicitanteDto(soli.getNombreSolicitante(), soli.getCargo(), soli.getIdAprovador(), soli.getAprovador());
		SolicitudDto solicitudDto = new SolicitudDto(solic.getNumero(), solic.getMonto(), solic.getIva(), solic.getPrioridad());
		
		RequestDto reqDto = new RequestDto(proveedorDto, areaDto, solicitanteDto, solicitudDto, req.getDescripcion());
		
		log.info("DTO ASIGNADOS CORRECTAMENTE");
		
		try {
			
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<RequestDto> entity = new HttpEntity<>(reqDto,headers);
			
			log.info("SOLICITANDO");
			
			Response res = restTemplate.exchange(
					URLs.targetURL, HttpMethod.POST, entity, Response.class).getBody();
			
			log.info("RESPONDIDO");
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			throw new BadRequestException(ExceptionPost.error);
		}
		
		
	
		
		
		
	}
	

}
