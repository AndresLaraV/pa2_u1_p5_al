package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insertar(transferencia);

	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);

	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		 //1. Buscar Cta origen
		CuentaBancaria ctaOrigen =this.bancariaRepository.seleccionar(numeroOrigen);
		 //2. Consultar saldo
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		 //3. Validar saldo
		if(saldoOrigen.compareTo(monto)>=0) {
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.bancariaRepository.actualizar(ctaOrigen);
			CuentaBancaria ctaDestino = this.bancariaRepository.seleccionar(numeroDestino);
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.bancariaRepository.actualizar(ctaDestino);
			Transferencia transferencia = new Transferencia();
			transferencia.setCuentaOrigen(ctaOrigen);
			transferencia.setCuentaDestino(ctaDestino);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setNumero("123123123");
			this.iTransferenciaRepository.insertar(transferencia);
			System.out.println("Transferenia realizada con Exito!");
		}else {
			System.out.println("Saldo no disponible");
		}
		 //4. Restar el monto
		 //5. Actualizar Cta origen
		
		 //6. Buscar Cta destino
		 //7. Consultar saldo
		 //8. Sumar el monto
		 //9. Actualizar cuenta destino
		 //10. Crear la transferencia
		
	}
}
