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

import br.edu.up.LoCARdora.entity.Funcionario;
import edu.up.br.LoCARdora.dao.FuncionarioDao;

@ManagedBean (name = "mBeanCadastroFuncionario")
public class MBeanCadastroFuncionario {
	
	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	private Integer id;
	private String email;
	private String senha;
	private String confirmarSenha;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private String cnh;
	private String carteiraDeTrabalho;
	private String estado;
	private String cidade;
	private String bairro;
	private String cep;
	private String rua;
	private String numeroCasa;
	private String cargo;
	private String deficiencia;
	private String experiencia;
	private String podeDirigir;
	private String telefone;
	private String observacoes;
	private String caminhoImagem;
	private ApplicationPart imagem;
	
	@PostConstruct
	public void carregar() {
		
		funcionarios = new FuncionarioDao().listar();
		
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
				
				Funcionario funcionario = new FuncionarioDao().buscar(this.id);
				caminhoImagem = funcionario.getCaminhoImagem();
				
			}
			
		}
		
		}

		Funcionario funcionario = new Funcionario();
		
		funcionario.setId(this.id);
		funcionario.setEmail(email);
		funcionario.setSenha(senha);
		funcionario.setConfirmarSenha(confirmarSenha);
		funcionario.setNome(nome);
		funcionario.setDataNascimento(dataNascimento);
		funcionario.setCpf(cpf);
		funcionario.setRg(rg);
		funcionario.setCnh(cnh);
		funcionario.setCarteiraDeTrabalho(carteiraDeTrabalho);
		funcionario.setEstado(estado);
		funcionario.setCidade(cidade);
		funcionario.setBairro(bairro);
		funcionario.setCep(cep);;
		funcionario.setRua(rua);
		funcionario.setNumeroCasa(numeroCasa);
		funcionario.setCargo(cargo);
		funcionario.setDeficiencia(deficiencia);
		funcionario.setExperiencia(experiencia);
		funcionario.setPodeDirigir(podeDirigir);
		funcionario.setTelefone(telefone);
		funcionario.setObservacoes(observacoes);
		funcionario.setCaminhoImagem(caminhoImagem);

		if (this.id == null) {
			
			new FuncionarioDao().inserir(funcionario);
			
		} else {
			
			new FuncionarioDao().alterar(funcionario);
			
		}

		funcionarios = new FuncionarioDao().listar();
		
	}
	
	public void alterar(Funcionario funcionario) {
		
		this.id = funcionario.getId();
		this.email = funcionario.getEmail();
		this.senha = funcionario.getSenha();
		this.confirmarSenha = funcionario.getConfirmarSenha();
		this.nome = funcionario.getNome();
		this.dataNascimento = funcionario.getDataNascimento();
		this.cpf = funcionario.getCpf();
		this.rg = funcionario.getRg();
		this.cnh = funcionario.getCnh();
		this.carteiraDeTrabalho = funcionario.getCarteiraDeTrabalho();
		this.estado = funcionario.getEstado();
		this.cidade = funcionario.getCidade();
		this.bairro = funcionario.getBairro();
		this.cep = funcionario.getCep();
		this.rua = funcionario.getRua();
		this.numeroCasa = funcionario.getNumeroCasa();
		this.cargo = funcionario.getCargo();
		this.deficiencia = funcionario.getDeficiencia();
		this.experiencia = funcionario.getExperiencia();
		this.podeDirigir = funcionario.getPodeDirigir();
		this.telefone = funcionario.getTelefone();
		this.observacoes = funcionario.getObservacoes();
		this.caminhoImagem = funcionario.getCaminhoImagem();
		
	}

	public String carregarFuncionario(Funcionario funcionario) {
		
		this.id = funcionario.getId();
		this.email = funcionario.getEmail();
		this.senha = funcionario.getSenha();
		this.confirmarSenha = funcionario.getConfirmarSenha();
		this.nome = funcionario.getNome();
		this.dataNascimento = funcionario.getDataNascimento();
		this.cpf = funcionario.getCpf();
		this.rg = funcionario.getRg();
		this.cnh = funcionario.getCnh();
		this.carteiraDeTrabalho = funcionario.getCarteiraDeTrabalho();
		this.estado = funcionario.getEstado();
		this.cidade = funcionario.getCidade();
		this.bairro = funcionario.getBairro();
		this.cep = funcionario.getCep();
		this.rua = funcionario.getRua();
		this.numeroCasa = funcionario.getNumeroCasa();
		this.cargo = funcionario.getCargo();
		this.deficiencia = funcionario.getDeficiencia();
		this.experiencia = funcionario.getExperiencia();
		this.podeDirigir = funcionario.getPodeDirigir();
		this.telefone = funcionario.getTelefone();
		this.observacoes = funcionario.getObservacoes();
		this.caminhoImagem = funcionario.getCaminhoImagem();

		return "PaginaInicial.jsf";
		
	}
	
	public String carregarFuncionarioEdicao(Funcionario funcionario) {
		
		this.alterar(funcionario);
		
		return "EditarFuncionario.jsf";
		
	}

	public void excluir(Funcionario funcionario) {
		
		new FuncionarioDao().remover(funcionario.getId());
		funcionarios = new FuncionarioDao().listar();
		
	}
	
	public String login() {

		Funcionario funcionario = new FuncionarioDao().buscar(email, senha);

		if (funcionario == null) {
			
			FacesContext.getCurrentInstance().
				addMessage("ERRO", 
			new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Login ou senha inválidos!", ""));
			return "";
			
		}	
	
		HttpServletRequest req = (HttpServletRequest) 
				FacesContext.getCurrentInstance().
				getExternalContext().getRequest();

		req.getSession().setAttribute("funcionario", funcionario);

		//""+req.getSession().getAttribute("pagina");
		
		return "PaginaInicial.jsf";
		
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getPodeDirigir() {
		return podeDirigir;
	}

	public void setPodeDirigir(String podeDirigir) {
		this.podeDirigir = podeDirigir;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
