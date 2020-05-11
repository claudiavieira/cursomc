package com.claudiavieira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiavieira.cursomc.domain.Pedido;
import com.claudiavieira.cursomc.repositories.PedidoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.claudiavieira.cursomc.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
