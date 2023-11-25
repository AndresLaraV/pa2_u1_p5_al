package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Repository
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {
	private static List<Transferencia> base = new ArrayList();

	@Override
	public Transferencia seleccionar(String numero) {

		for (Transferencia transfer : base) {
			if (transfer.getNumero().equals(numero)) {
				return transfer;
			}
		}

		return null;
	}

	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		base.add(transferencia);

	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);

	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		Transferencia transferencia = this.seleccionar(numero);
		base.remove(transferencia);
	}

}
