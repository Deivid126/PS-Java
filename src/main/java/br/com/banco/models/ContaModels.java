package br.com.banco.models;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="conta")
public class ContaModels {
    @Id
    private Long id_conta;
    private String nome_responsavel;




    public ContaModels() {}


    public ContaModels(Long id_conta, String nome_responsavel){
        this.id_conta = id_conta;
        this.nome_responsavel = nome_responsavel;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public Long getId() {
        return id_conta;
    }

    public void setId(Long id_conta) {
        this.id_conta = id_conta;
    }

}
