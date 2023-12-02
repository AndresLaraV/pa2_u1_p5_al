package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5AlApplication implements CommandLineRunner {

	@Autowired
	private IInventarioService InventarioService;

	@Autowired
	private IBodegaService bodegaService;

	@Autowired
	private IProductoService iProductoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5AlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Producto p1 = new Producto();
		p1.setCodigoBarras("P1");
		p1.setNombre("HP");
		p1.setStock(0);
		this.iProductoService.insertar(p1);

		Producto p2 = new Producto();
		p2.setCodigoBarras("P2");
		p2.setNombre("Lenovo");
		p2.setStock(0);
		this.iProductoService.insertar(p2);

		Bodega bod = new Bodega();
		bod.setCapacidad(100);
		bod.setCodigo("B1");
		bod.setDireccion("Calderon");
		bod.setNombre("Bodega Don Fenix");
		this.bodegaService.guardar(bod);

		Inventario inv1 = new Inventario();
		inv1.setCodigo("555555");
		this.InventarioService.registrar("P1", "B1", 50);
		
		Inventario inv2 = new Inventario();
		inv2.setCodigo("555555");
		this.InventarioService.registrar("P1", "B1", 100);
		
		Inventario inv3 = new Inventario();
		inv3.setCodigo("555555");
		this.InventarioService.registrar("P1", "B1", 20);
	}
}
