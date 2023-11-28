package com.uce.edu.transferencia.repository;

import java.util.List;

import com.uce.edu.transferencia.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	// CRUD
	public Transferencia seleccionar(String numero);

	public void insertar(Transferencia transferencia);

	public void actualizar(Transferencia transferencia);

	public void eliminar(String numero);
	
	public List <Transferencia> seleccionarTodos();
}
