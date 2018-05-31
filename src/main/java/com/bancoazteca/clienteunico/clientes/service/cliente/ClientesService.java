package com.bancoazteca.clienteunico.clientes.service.cliente;

import com.bancoazteca.clienteunico.clientes.modelo.ClienteBean;
import com.bancoazteca.clienteunico.clientes.service.creditos.modelo.ResumenCredito;
import com.bancoazteca.clienteunico.clientes.service.creditos.modelo.Credito;

/**
 * <b>ClientesService.java</b>
 *
 * @author Jovani AC
 * @version 1.0
 * @ultimaModificacion 3 marzo. 2018 12:39:12
 * @Servicio de Cliente Unico
 */
public interface ClientesService {

    ClienteBean guardarCliente(ClienteBean clienteBean);
    ClienteBean consultarCliente(String idCliente);
    void borrarCliente(String idCliente);
    void modificar(String idCliente);
    ResumenCredito generarCredito(Credito credito);

}
