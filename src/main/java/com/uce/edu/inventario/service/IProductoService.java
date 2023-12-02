package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.modelo.Producto;

public interface IProductoService {
	public Producto seleccionar(String codigoBarras);

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public void eliminar(String codigoBarras);
	
}
