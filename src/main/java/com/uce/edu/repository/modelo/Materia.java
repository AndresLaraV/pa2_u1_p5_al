package com.uce.edu.repository.modelo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Materia {
	private String nombre;
	private String codigo;
	private Integer numeroCredito;

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", codigo=" + codigo + ", numeroCredito=" + numeroCredito + "]";
	}

	// getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getNumeroCredito() {
		return numeroCredito;
	}

	public void setNumeroCredito(Integer numeroCredito) {
		this.numeroCredito = numeroCredito;
	}
}
