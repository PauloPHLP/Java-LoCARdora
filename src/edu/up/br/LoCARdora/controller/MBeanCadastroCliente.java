package edu.up.br.LoCARdora.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.core.ApplicationPart;

import br.edu.up.LoCARdora.entity.Cliente;
import edu.up.br.LoCARdora.dao.ClienteDao;

@ManagedBean (name = "mBeanCadastroCliente")
public class MBeanCadastroCliente {
	
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	private Integer id;
	private String email;
	private String senha;
	private String confirmarSenha;
	private String nome;
	private Date dataNascimento;
	private String cpfCnpj;
	private String rg;
	private String cnh;
	private String estado;
	private String cidade;
	private String bairro;
	private String cep;
	private String rua;
	private String numeroCasa;
	private String telefone;
	private String tipo;
	private String observacoes;
	private String caminhoImagem;
	private ApplicationPart imagem;
	
	@PostConstruct
	public void carregar() {
		
		clientes = new ClienteDao().listar();
		
	}
	
	public void salvar() {

		if (imagem != null && !imagem.getSubmittedFileName().equals("")) {
			
		caminhoImagem = "C:\\Users\\paulo\\Pictures\\Projetos de sites\\LoCARdora\\Imagens"+imagem.getSubmittedFileName();
		
		try {
			
			byte [] bytesImagem = new byte[(int) imagem.getSize()];
			imagem.getInputStream().read(bytesImagem);			
			File f = new File(caminhoImagem);
			@SuppressWarnings("resource")
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytesImagem);			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			if (this.id != null) {
				
				Cliente cliente = new ClienteDao().buscar(this.id);
				caminhoImagem = cliente.getCaminhoImagem();
				
			}
			
		}
		
		}

		Cliente cliente = new Cliente();
		
		cliente.setId(this.id);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setConfirmarSenha(confirmarSenha);
		cliente.setNome(nome);
		cliente.setDataNascimento(dataNascimento);
		cliente.setCpfCnpj(cpfCnpj);
		cliente.setRg(rg);
		cliente.setCnh(cnh);
		cliente.setEstado(estado);
		cliente.setCidade(cidade);
		cliente.setBairro(bairro);
		cliente.setCep(cep);;
		cliente.setRua(rua);
		cliente.setNumeroCasa(numeroCasa);
		cliente.setTelefone(telefone);
		cliente.setTipo(tipo);
		cliente.setObservacoes(observacoes);
		cliente.setCaminhoImagem(caminhoImagem);

		if (this.id == null) {
			
			new ClienteDao().inserir(cliente);
			
		} else {
			
			new ClienteDao().alterar(cliente);
			
		}

		clientes = new ClienteDao().listar();
		
	}
	
	public void alterar(Cliente cliente) {
		
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.confirmarSenha = cliente.getConfirmarSenha();
		this.nome = cliente.getNome();
		this.dataNascimento = cliente.getDataNascimento();
		this.cpfCnpj = cliente.getCpfCnpj();
		this.rg = cliente.getRg();
		this.cnh = cliente.getCnh();
		this.estado = cliente.getEstado();
		this.cidade = cliente.getCidade();
		this.bairro = cliente.getBairro();
		this.cep = cliente.getCep();
		this.rua = cliente.getRua();
		this.numeroCasa = cliente.getNumeroCasa();
		this.telefone = cliente.getTelefone();
		this.tipo = cliente.getTipo();
		this.observacoes = cliente.getObservacoes();
		this.caminhoImagem = cliente.getCaminhoImagem();
		
	}

	public String carregarCliente(Cliente cliente) {
		
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.confirmarSenha = cliente.getConfirmarSenha();
		this.nome = cliente.getNome();
		this.dataNascimento = cliente.getDataNascimento();
		this.cpfCnpj = cliente.getCpfCnpj();
		this.rg = cliente.getRg();
		this.cnh = cliente.getCnh();
		this.estado = cliente.getEstado();
		this.cidade = cliente.getCidade();
		this.bairro = cliente.getBairro();
		this.cep = cliente.getCep();
		this.rua = cliente.getRua();
		this.numeroCasa = cliente.getNumeroCasa();
		this.telefone = cliente.getTelefone();
		this.tipo = cliente.getTipo();
		this.observacoes = cliente.getObservacoes();
		this.caminhoImagem = cliente.getCaminhoImagem();

		return "PaginaInicial.jsf";
		
	}
	
	public String carregarClienteEdicao(Cliente cliente) {
		
		this.alterar(cliente);
		
		return "EditarCliente.jsf";
		
	}

	public void excluir(Cliente cliente) {
		
		new ClienteDao().remover(cliente.getId());
		clientes = new ClienteDao().listar();
		
	}
	
	public String login() {

		Cliente cliente = new ClienteDao().buscar(email, senha);

		if (cliente == null) {
			
			FacesContext.getCurrentInstance().
				addMessage("", 
			new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Login ou senha inválidos!", ""));
			return "";
			
		}	
	
		HttpServletRequest req = (HttpServletRequest) 
				FacesContext.getCurrentInstance().
				getExternalContext().getRequest();

		req.getSession().setAttribute("cliente", cliente);

		//""+req.getSession().getAttribute("pagina");
		
		return "PaginaInicial.jsf";
		
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public ApplicationPart getImagem() {
		return imagem;
	}

	public void setImagem(ApplicationPart imagem) {
		this.imagem = imagem;
	}
	
}
