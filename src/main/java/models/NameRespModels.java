package models;

import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="conta")
public class NameRespModels implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_conta;
	@Column(nullable = false, length = 50)
	private String nome_responsavel;
	
	
	
	public long getId_conta() {
		return id_conta;
	}
	public void setId_conta(long id_conta) {
		this.id_conta = id_conta;
	}
	public String getNome_responsavel() {
		return nome_responsavel;
	}
	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}
	
}


