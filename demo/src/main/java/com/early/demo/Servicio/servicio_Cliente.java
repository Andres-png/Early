package com.early.demo.Servicio;

import com.early.demo.Entidades.Cliente;
import com.early.demo.Repositorios.Cliente_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicio_Cliente {

    @Autowired
    private Cliente_Repository clienteRepo;
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }


    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Cliente editarCliente(Cliente cliente) {
        if (cliente == null || cliente.getIdUsuario() == null) {
            return null;
        }

        Cliente clienteExistente = clienteRepo.getReferenceById(cliente.getIdUsuario());
        if (clienteExistente != null) {

            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setDireccion(cliente.getDireccion());
            return clienteRepo.save(clienteExistente);
        }
        return null;
    }


    public Cliente eliminarCliente(Integer id) {
        Cliente cliente = clienteRepo.findById(id).orElse(null);

        if (cliente != null) {
            clienteRepo.delete(cliente);
            System.out.println("Cliente con ID " + id + " eliminado.");
            return cliente;
        } else {
            System.out.println("Cliente con ID " + id + " no encontrado.");
            return null;
        }
    }
}

