package com.ekan.prova.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekan.prova.daos.BeneficiarioRepository;
import com.ekan.prova.daos.DocumentoRepository;
import com.ekan.prova.models.Beneficiario;
import com.ekan.prova.models.Documento;

@RestController
@RequestMapping("/rest")
class BeneficiarioController {
	
	@Autowired
    private BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
    private DocumentoRepository documentoRepository;
	
	
    @GetMapping("/findById/{id}")
    Optional<Beneficiario> findById(@PathVariable Long id){
    	return beneficiarioRepository.findById(id);
    }
    
    @GetMapping("/findAll")
    List<Beneficiario> findAll(){
    	return beneficiarioRepository.findAll();
    }

    @DeleteMapping("/removeBeneficiario/{id}")
    void removeBeneficiario(@PathVariable("id") Long id){
    	beneficiarioRepository.deleteById(id);
    }
    
    @PostMapping("/insereBeneficiario")
    Beneficiario insereBeneficiario(@RequestBody Beneficiario newBeneficiario) {
    	newBeneficiario.setDataInclusao(new Date());
    	return beneficiarioRepository.save(newBeneficiario);
    }
    
    @PatchMapping("/atualizaBeneficiario")
    void atualizaBeneficiario(@RequestBody Beneficiario updateBeneficiario) {
    	Optional<Beneficiario> existingBeneficiario=beneficiarioRepository.findById(updateBeneficiario.getId());
    	
    	if(existingBeneficiario.isPresent()) {
    		
			if(updateBeneficiario.getNome() != null){
				existingBeneficiario.get().setNome(updateBeneficiario.getNome());
			}
			
			if(updateBeneficiario.getTelefone() != null){
				existingBeneficiario.get().setTelefone(updateBeneficiario.getTelefone());
			}
			
			if(updateBeneficiario.getDataNascimento() != null){
				existingBeneficiario.get().setDataNascimento(updateBeneficiario.getDataNascimento());
			}
			
			existingBeneficiario.get().setDataAtualizacao(new Date());
			
			beneficiarioRepository.save(existingBeneficiario.get());
    	}
    	
    }
    
    @GetMapping("/listaDocumentosByBeneficiarioId/{id}")
    List<Documento> listaDocumentosByBeneficiarioId(@PathVariable Long id){
    	
    	List<Documento> documentList = documentoRepository.listaDocumentosByBeneficiarioId(id);
    	
    	if(documentList != null) {
    		return documentList;
    	}
    	else {
    		return null;	
    	}
    	
    }
    
    @PostMapping("/insereDocumento")
    void insereDocumento(@RequestBody Documento newDocumento) {
    	
    	Optional<Beneficiario> existingBeneficiario=beneficiarioRepository.findById(newDocumento.getId());
    	if(existingBeneficiario.isPresent()) {
    		
        	Documento newDocumento2 = new Documento();
        	newDocumento2.setBeneficiario(existingBeneficiario.get());
        	newDocumento2.setDataInclusao(new Date());
        	newDocumento2.setDescricao(newDocumento.getDescricao());
        	newDocumento2.setTipoDocumento(newDocumento.getTipoDocumento());
        	
        	documentoRepository.save(newDocumento2);
    	}
    }

    @PatchMapping("/atualizaDocumento")
    void atualizaDocumento(@RequestBody Documento newDocumento) {
    	
    	Optional<Documento> existingDocumento=documentoRepository.findById(newDocumento.getId());
    	if(existingDocumento.isPresent()) {
    		
    		existingDocumento.get().setDataAtualizacao(new Date());
        	
			if(newDocumento.getDescricao() != null){
				existingDocumento.get().setDescricao(newDocumento.getDescricao());
			}
			
			if(newDocumento.getTipoDocumento() != null){
				existingDocumento.get().setTipoDocumento(newDocumento.getTipoDocumento());
			}
        	
        	documentoRepository.save(existingDocumento.get());
    	}
    }

}