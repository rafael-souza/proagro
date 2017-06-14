package br.net.proex.entity.cad;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.domain.validation.PlcValCnpj;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;

import br.net.proex.commons.component.CadEndereco;
import br.net.proex.entity.AppBaseEntity;

/**
 * Cadastro de propriedades
 * @author rafael
 *
 */
@Audited
@MappedSuperclass
public abstract class CadPropriedade extends AppBaseEntity {

	
	@OneToMany (targetEntity = br.net.proex.entity.cad.CadPropriedadeAreaEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="propriedade")
	@ForeignKey(name="FK_CADAREAPROPRIEDADE_CADPROPRIEDADE")
	@PlcValDuplicity(property="nome")
	@PlcValMultiplicity(referenceProperty="nome",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.CadAreaPropriedadeEntity}")
	@Valid
	private List<CadPropriedadeAreaEntity> propriedadeArea;
	
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
	
	@Size(max = 50)
	private String latitude;
	
	@Size(max = 50)
	private String longitude;
	
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

	/**
	 * @return the propriedadeArea
	 */
	public List<CadPropriedadeAreaEntity> getPropriedadeArea() {
		return propriedadeArea;
	}

	/**
	 * @param propriedadeArea the propriedadeArea to set
	 */
	public void setPropriedadeArea(List<CadPropriedadeAreaEntity> propriedadeArea) {
		this.propriedadeArea = propriedadeArea;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



}
