package br.com.banco.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="transferencia")
public class TransferenciaModels implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false,name = "data_transferencia")
	private LocalDate data_transferencia;
	@Column(nullable = false,name = "valor")
	private long valor;
	@Column(nullable = false, length = 15,name = "tipo")
	private String tipo;
	@Column(nullable = true, length = 50,name = "nome_operador_transacao")
	private String nome_operador_transacao;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="conta_id")
	private ContaModels conta_id;

	public TransferenciaModels() {
	}

	public TransferenciaModels(int id, LocalDate data_transferencia, Long valor, String tipo, String nome_operador_transacao, ContaModels conta_id){
		this.id = id;
		this.data_transferencia = data_transferencia;
		this.valor = valor;
		this.tipo = tipo;
		this.nome_operador_transacao = nome_operador_transacao;
		this.conta_id = conta_id;
	}


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
	public ContaModels getId_conta() {
		return conta_id;
	}
	public void setId_conta(ContaModels id_conta) {
		this.conta_id = conta_id;
	}
	
	
	
	

}
