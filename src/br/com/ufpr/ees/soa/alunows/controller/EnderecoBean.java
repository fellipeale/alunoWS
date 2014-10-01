package br.com.ufpr.ees.soa.alunows.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class EnderecoBean {
	
	public SelectItem[] getUFs(){
		return new SelectItem[] {
			new SelectItem("AC","Acre"),
			new SelectItem("AL","Alagoas"),
			new SelectItem("AM","Amazonas"),
			new SelectItem("AP","Amapá"),
			new SelectItem("BA","Bahia"),
			new SelectItem("CE","Ceará"),
			new SelectItem("DF","Distrito Federal"),
			new SelectItem("ES","Espírito Santo"),
			new SelectItem("GO","Goiás"),
			new SelectItem("MA","Maranhão"),
			new SelectItem("MG","Minas Gerais"),
			new SelectItem("MS","Mato Grosso do Sul"),
			new SelectItem("MT","Mato Grosso"),
			new SelectItem("PA","Pará"),
			new SelectItem("PB","Paraíba"),
			new SelectItem("PE","Pernambuco"),
			new SelectItem("PI","Piauí"),
			new SelectItem("PR","Paraná"),
			new SelectItem("RJ","Rio de Janeiro"),
			new SelectItem("RN","Rio Grande do Norte"),
			new SelectItem("RO","Rondônia"),
			new SelectItem("RR","Roraima"),
			new SelectItem("RS","Rio Grande do Sul"),
			new SelectItem("SC","Santa Catarina"),
			new SelectItem("SE","Sergipe"),
			new SelectItem("SP","São Paulo"),
			new SelectItem("TO","Tocantins")
		};
	}

}
