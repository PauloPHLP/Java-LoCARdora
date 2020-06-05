package edu.up.br.LoCARdora.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.edu.up.LoCARdora.entity.Cliente;
import br.edu.up.LoCARdora.entity.Item;
import br.edu.up.LoCARdora.entity.Pedido;
import br.edu.up.LoCARdora.entity.Veiculo;
import edu.up.br.LoCARdora.dao.PedidoDao;
import edu.up.br.LoCARdora.dao.VeiculoDao;

@ManagedBean(name = "mBeanCarrinho")
@SessionScoped
public class MBeanCarrinho {
	
	private ArrayList<Item> itens = new ArrayList<Item>();
	
	public String salvarPedido() {
		
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		Cliente u = (Cliente) req.getSession().getAttribute("cliente");
		Pedido p = new Pedido();
		p.setData(new Date());
		p.setItens(itens);
		p.setCliente(u);
		
		for (Item i : itens) {
			
			i.setPedido(p);
			
		}
		
		new PedidoDao().inserir(p);
		
		itens.clear();
		
		return "PaginaInicial.jsf";
		
	}
	
	public void adicionar(Integer idVeiculo) throws IOException {
		Veiculo veiculo = new VeiculoDao().buscar(idVeiculo);
		
		Integer passe = 0;
		
		Item item = new Item();
		item.setVeiculo(veiculo);
		
		for (int i = 0; i < itens.size(); i++) {
			
			if (itens.get(i).getVeiculo().getId().equals(item.getVeiculo().getId()) == true) {
				
				itens.get(i).setQuantidade(itens.get(i).getQuantidade() + 1);
				passe++;
				
			} 
			
		}
		
		if (passe == 0) {
			
			item.setQuantidade(1);
			itens.add(item);
				
		}
		
		FacesContext.
			getCurrentInstance().
			getExternalContext().redirect("CarrinhoDeLocacao.jsf");	
		
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

}
