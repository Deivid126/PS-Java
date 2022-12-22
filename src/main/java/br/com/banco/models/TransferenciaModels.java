package br.com.banco.models;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transferencia")
public class TransferenciaModels implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private LocalDate data_transferencia;
	@Column(nullable = false)
	private long valor;
	@Column(nullable = false, length = 15)
	private String tipo;
	@Column(nullable = true, length = 50)
	private String nome_operador_transacao;
	@Column(nullable = false)
	private long id_conta;
	
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData_transferencia() {
		return data_transferencia;
	}
	public void setData_transferencia(LocalDate data_transferencia) {
		this.data_transferencia = data_transferencia;
	}
	public long getValor() {
		return valor;
	}
	public void setValor(long valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome_operador_transacao() {
		return nome_operador_transacao;
	}
	public void setNome_operador_transacao(String nome_operador_transacao) {
		this.nome_operador_transacao = nome_operador_transacao;
	}
	public long getId_conta() {
		return id_conta;
	}
	public void setId_conta(long id_conta) {
		this.id_conta = id_conta;
	}
	
	
	
	

}
