package br.edu.up.LoCARdora.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_VEICULO")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	private String caminhoImagem;
	
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
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	
}
