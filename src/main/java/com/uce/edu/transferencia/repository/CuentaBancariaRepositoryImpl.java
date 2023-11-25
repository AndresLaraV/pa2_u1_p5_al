package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

@Repository
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {
	private static List<CuentaBancaria> base = new ArrayList();

	@Override
	public CuentaBancaria seleccionar(String numero) {

		for (CuentaBancaria cuenta : base) {
			if (cuenta.getNumero().equals(numero)) {
				return cuenta;
			}
		}
		return null;
	}

	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		base.add(cuentaBancaria);

	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.eliminar(cuentaBancaria.getNumero());
		this.insertar(cuentaBancaria);

	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		CuentaBancaria cuentaBancaria = this.seleccionar(numero);
		base.remove(numero);

	}

}
