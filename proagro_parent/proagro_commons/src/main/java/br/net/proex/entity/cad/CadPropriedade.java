package br.net.proex.entity.cad;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;

import com.powerlogic.jcompany.domain.validation.PlcValCnpj;

import br.net.proex.commons.component.CadEndereco;
import br.net.proex.entity.AppBaseEntity;

/**
 * Cadastro de propriedades
 * @author rafael
 *
 */
@MappedSuperclass
public abstract class CadPropriedade extends AppBaseEntity {

	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_propriedade")
	private Long id;
	
	@NotNull
	@Size(max = 120)
	private String nome;
			
	@Size(max = 120)
	private String razaoSocial;
			
	@PlcValCnpj
	private String cnpj;
		
	@Size(max = 14)
	private String ie;
		
	@Digits(integer=15, fraction=2)
	private BigDecimal areaTotal;
		
	@Embedded	
	@Valid
	private CadEndereco endereco;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial=razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj=cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie=ie;
	}

	public BigDecimal getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(BigDecimal areaTotal) {
		this.areaTotal=areaTotal;
	}

	public CadEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(CadEndereco endereco) {
		this.endereco=endereco;
	}

}
