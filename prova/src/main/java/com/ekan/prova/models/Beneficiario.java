package com.ekan.prova.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Beneficiario")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = true)
    private String telefone;
    
    @Column(nullable = true)
    private Date dataNascimento;
    
    @Column(nullable = true)
    private Date dataInclusao;
    
    @Column(nullable = true)
    private Date dataAtualizacao;
    
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL)
	private List<Documento> documentList;
    
    public Beneficiario() {
    	this.dataInclusao = new Date();
    }

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<Documento> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<Documento> documentList) {
		this.documentList = documentList;
	}





    
}
