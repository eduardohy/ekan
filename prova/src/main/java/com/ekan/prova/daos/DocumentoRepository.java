package com.ekan.prova.daos;

import java.util.List;
import java.util.Optional;

import javax.swing.text.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ekan.prova.models.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long>{

	@Query(value = "SELECT * FROM Documento WHERE beneficiario_id = ?1", nativeQuery = true)
	public List<Documento> listaDocumentosByBeneficiarioId(Long id);
	
}
