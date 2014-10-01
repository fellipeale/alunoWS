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
			new SelectItem("AP","Amap�"),
			new SelectItem("BA","Bahia"),
			new SelectItem("CE","Cear�"),
			new SelectItem("DF","Distrito Federal"),
			new SelectItem("ES","Esp�rito Santo"),
			new SelectItem("GO","Goi�s"),
			new SelectItem("MA","Maranh�o"),
			new SelectItem("MG","Minas Gerais"),
			new SelectItem("MS","Mato Grosso do Sul"),
			new SelectItem("MT","Mato Grosso"),
			new SelectItem("PA","Par�"),
			new SelectItem("PB","Para�ba"),
			new SelectItem("PE","Pernambuco"),
			new SelectItem("PI","Piau�"),
			new SelectItem("PR","Paran�"),
			new SelectItem("RJ","Rio de Janeiro"),
			new SelectItem("RN","Rio Grande do Norte"),
			new SelectItem("RO","Rond�nia"),
			new SelectItem("RR","Roraima"),
			new SelectItem("RS","Rio Grande do Sul"),
			new SelectItem("SC","Santa Catarina"),
			new SelectItem("SE","Sergipe"),
			new SelectItem("SP","S�o Paulo"),
			new SelectItem("TO","Tocantins")
		};
	}

}
