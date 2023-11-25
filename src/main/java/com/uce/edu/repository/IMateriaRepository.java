package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Materia;

public interface IMateriaRepository {
	public Materia seleccionar(String codigo);

	public void insertar(Materia materia);

	public void actualizar(Materia materia);

	// se borra a partir de un criterio
	public void borrar(String codigo);


	List<Materia> seleccionarTodos();
}
