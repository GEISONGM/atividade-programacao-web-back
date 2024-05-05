package br.com.cadUser;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean


public class pessoa {
	private String nome;
	private ArrayList<String> nomesDigitados = new ArrayList<String>();
	
	
	public static void main(String[] args) {
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public ArrayList<String> getNomesDigitados(){
		return this.nomesDigitados;
	}
	
	public void adicionarNome(){ 
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		ArrayList<String> valorLista = (ArrayList<String>) session.getAttribute("valorLista");
		String valorInput = request.getParameter("idNome");
		if(valorLista == null) {
			valorLista = new ArrayList<String>();
			valorLista.add(valorInput);
			session.setAttribute("valorLista", valorLista);
			this.nomesDigitados = valorLista;
		}else {
			valorLista.add(valorInput);
			this.nomesDigitados = valorLista;
		}
     
		System.out.print(this.nomesDigitados);
		
	}
	
}