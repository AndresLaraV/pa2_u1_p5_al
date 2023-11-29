package com.uce.edu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5AlApplication implements CommandLineRunner {
	
	//Inyeccion de dependencia por atributo
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	//Inyeccion de dependencia por constructor
	/*
	@Autowired
	public Pa2U1P5AlApplication(ITransferenciaService iTransferenciaServi) {
		this.iTransferenciaService = iTransferenciaServi;
	}*/
	
	/*Iyeccion de dependencia por método (set)
	private ITransferenciaService iTransferenciaService;
	@Autowired
	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService = iTransferenciaService;
	}*/
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5AlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1722121835");
		ctaOrigen.setSaldo(new BigDecimal(100));
		ctaOrigen.setNumero("1234");
		this.bancariaService.guardar(ctaOrigen);
		
		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1704983491");
		ctaDestino.setSaldo(new BigDecimal(200));
		ctaDestino.setNumero("5678");
		this.bancariaService.guardar(ctaDestino);
		
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(10));
		
		CuentaBancaria ctaOrigen1 = this.bancariaService.buscar("1234");
		System.out.println(ctaOrigen1);
		
		CuentaBancaria ctaDestino1 = this.bancariaService.buscar("5678");
		System.out.println(ctaDestino1);
		
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(30));
		this.iTransferenciaService.realizar("5678", "1234", new BigDecimal(10));
		
		
		
		 List<Transferencia> lista = this.iTransferenciaService.buscarTodos();
 
		
		int indice = 0;
		for (Transferencia trans:lista) {
			indice++;
			System.out.println(indice+ ": "+trans);
		}
		
		
		CuentaBancaria ctaOrigen2 = this.bancariaService.buscar("1234");
		System.out.println(ctaOrigen2);
		
		CuentaBancaria ctaDestino2 = this.bancariaService.buscar("5678");
		System.out.println(ctaDestino2);
		
		}
	}

