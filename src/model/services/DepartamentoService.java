package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Departamento;

public class DepartamentoService {

	public List<Departamento> findAll(){
		List<Departamento> lista = new ArrayList<>();
		lista.add(new Departamento(1, "Contabilidade"));
		lista.add(new Departamento(2, "TI"));
		lista.add(new Departamento(3, "RH"));
		
		return lista;
	}
}
