package edu.up.br.LoCARdora.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import org.apache.catalina.core.ApplicationPart;

import br.edu.up.LoCARdora.entity.Veiculo;
import edu.up.br.LoCARdora.dao.VeiculoDao;

@ManagedBean(name = "mBeanCadastroVeiculo")
public class MBeanCadastroVeiculo {
	
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	private Integer id;
	private String tipo;
	private String fabricante;
	private String modelo;
	private BigDecimal preco;
	private Date anoLancamento;
	private String carroceria;
	private String ocupantes;
	private String cilindradas;
	private String pesoPotencia;
	private String potencia;
	private String torque;
	private String velocidadeMaxima;
	private String aceleracao;
	private String combustivel;
	private String consumo;
	private String tracao;
	private String peso;
	private String cambio;
	private String numeroMarchas;
	private BigDecimal valorHora;
	private String placa;
	private String descricao;
	private ApplicationPart imagem;
	private String caminhoImagem;
	
	@PostConstruct
	public void carregar() {
		
		veiculos = new VeiculoDao().listar();
		
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
				
				Veiculo veiculo1 = new VeiculoDao().buscar(this.id);
				caminhoImagem = veiculo1.getCaminhoImagem();
				
			}
			
		}
		
		}
		
		Veiculo veiculo = new Veiculo();

		veiculo.setId(this.id);
		veiculo.setTipo(tipo);
		veiculo.setFabricante(fabricante);
		veiculo.setModelo(modelo);
		veiculo.setPreco(preco);
		veiculo.setAnoLancamento(anoLancamento);
		veiculo.setCarroceria(carroceria);
		veiculo.setOcupantes(ocupantes);
		veiculo.setCilindradas(cilindradas);
		veiculo.setPesoPotencia(pesoPotencia);
		veiculo.setPotencia(potencia);
		veiculo.setTorque(torque);
		veiculo.setVelocidadeMaxima(velocidadeMaxima);
		veiculo.setAceleracao(aceleracao);
		veiculo.setCombustivel(combustivel);
		veiculo.setConsumo(consumo);
		veiculo.setTracao(tracao);
		veiculo.setPeso(peso);
		veiculo.setCambio(cambio);
		veiculo.setNumeroMarchas(numeroMarchas);
		veiculo.setValorHora(valorHora);
		veiculo.setPlaca(placa);
		veiculo.setDescricao(descricao);
		veiculo.setCaminhoImagem(caminhoImagem);
		
		if (this.id == null) {
			
			new VeiculoDao().inserir(veiculo);
			
		} else {
			
			new VeiculoDao().alterar(veiculo);
	
		}

		veiculos = new VeiculoDao().listar();
		
	}

	public void alterar(Veiculo veiculo) {
		
		this.id = veiculo.getId();
		this.tipo = veiculo.getTipo();
		this.fabricante = veiculo.getFabricante();
		this.modelo = veiculo.getModelo();
		this.preco = veiculo.getPreco();
		this.anoLancamento = veiculo.getAnoLancamento();
		this.carroceria = veiculo.getCarroceria();
		this.ocupantes = veiculo.getOcupantes();
		this.cilindradas = veiculo.getCilindradas();
		this.pesoPotencia = veiculo.getPesoPotencia();
		this.potencia = veiculo.getPotencia();
		this.torque = veiculo.getTorque();
		this.velocidadeMaxima = veiculo.getVelocidadeMaxima();
		this.aceleracao = veiculo.getAceleracao();
		this.combustivel = veiculo.getCombustivel();
		this.consumo = veiculo.getConsumo();
		this.tracao = veiculo.getTracao();
		this.peso = veiculo.getPeso();
		this.cambio = veiculo.getCambio();
		this.numeroMarchas = veiculo.getNumeroMarchas();
		this.valorHora = veiculo.getValorHora();
		this.placa = veiculo.getPlaca();
		this.descricao = veiculo.getDescricao();
		this.caminhoImagem = veiculo.getCaminhoImagem();
		
	}
	
	public void mostrarCarro(ValueChangeEvent event) {
		
		tipo = event.getNewValue().toString();
		
		veiculos = new VeiculoDao().listarCarros(tipo);

	}
	
	public String carregarVeiculo(Veiculo veiculo) {
		
		this.id = veiculo.getId();
		this.tipo = veiculo.getTipo();
		this.fabricante = veiculo.getFabricante();
		this.modelo = veiculo.getModelo();
		this.preco = veiculo.getPreco();
		this.anoLancamento = veiculo.getAnoLancamento();
		this.carroceria = veiculo.getCarroceria();
		this.ocupantes = veiculo.getOcupantes();
		this.cilindradas = veiculo.getCilindradas();
		this.pesoPotencia = veiculo.getPesoPotencia();
		this.potencia = veiculo.getPotencia();
		this.torque = veiculo.getTorque();
		this.velocidadeMaxima = veiculo.getVelocidadeMaxima();
		this.aceleracao = veiculo.getAceleracao();
		this.combustivel = veiculo.getCombustivel();
		this.consumo = veiculo.getConsumo();
		this.tracao = veiculo.getTracao();
		this.peso = veiculo.getPeso();
		this.cambio = veiculo.getCambio();
		this.numeroMarchas = veiculo.getNumeroMarchas();
		this.valorHora = veiculo.getValorHora();
		this.placa = veiculo.getPlaca();
		this.descricao = veiculo.getDescricao();
		this.caminhoImagem = veiculo.getCaminhoImagem();
		
		return "DetalhesDoVeiculo.jsf";
		
	}
	
	public String carregarVeiculoEdicao(Veiculo veiculo) {
		
		this.alterar(veiculo);
		
		return "EditarVeiculo.jsf";
		
	}

	public void excluir(Veiculo veiculo) {
		
		new VeiculoDao().remover(veiculo.getId());
		veiculos = new VeiculoDao().listar();
		
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Date anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public String getOcupantes() {
		return ocupantes;
	}

	public void setOcupantes(String ocupantes) {
		this.ocupantes = ocupantes;
	}

	public String getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(String cilindradas) {
		this.cilindradas = cilindradas;
	}

	public String getPesoPotencia() {
		return pesoPotencia;
	}

	public void setPesoPotencia(String pesoPotencia) {
		this.pesoPotencia = pesoPotencia;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getTorque() {
		return torque;
	}

	public void setTorque(String torque) {
		this.torque = torque;
	}

	public String getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(String velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public String getAceleracao() {
		return aceleracao;
	}

	public void setAceleracao(String aceleracao) {
		this.aceleracao = aceleracao;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	public String getTracao() {
		return tracao;
	}

	public void setTracao(String tracao) {
		this.tracao = tracao;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getNumeroMarchas() {
		return numeroMarchas;
	}

	public void setNumeroMarchas(String numeroMarchas) {
		this.numeroMarchas = numeroMarchas;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ApplicationPart getImagem() {
		return imagem;
	}

	public void setImagem(ApplicationPart imagem) {
		this.imagem = imagem;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	
}
