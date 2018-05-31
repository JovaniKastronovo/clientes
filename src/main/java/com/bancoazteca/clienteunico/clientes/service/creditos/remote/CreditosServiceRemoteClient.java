package com.bancoazteca.clienteunico.clientes.service.creditos.remote;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bancoazteca.clienteunico.clientes.service.creditos.modelo.Credito;
import com.bancoazteca.clienteunico.clientes.service.creditos.modelo.ResumenCredito;

@FeignClient(name = "servicio-creditos-tracing", url = "http://servicio-creditos-tracing:8082") 
public interface CreditosServiceRemoteClient {
	
	
	@RequestMapping(method = POST, value = "api/v1/creditos")
	ResumenCredito guardarCredito(@RequestBody Credito credito);
}
