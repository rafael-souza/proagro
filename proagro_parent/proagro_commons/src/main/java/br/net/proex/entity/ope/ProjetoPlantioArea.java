package br.net.proex.entity.ope;

import java.math.BigDecimal;

import br.net.proex.entity.AppBaseEntity;
import br.net.proex.entity.cad.CadPropriedadeAreaEntity;
import br.net.proex.enumeration.CadMeses;
import br.net.proex.enumeration.OpeSistemaHidrico;
import br.net.proex.enumeration.OpeSistemaPlantio;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.validation.constraints.NotNull;
import javax.persistence.EnumType;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;
import javax.validation.constraints.Digits;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.List;
import javax.validation.Valid;
import javax.persistence.CascadeType;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.OneToMany;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;

@Audited
@MappedSuperclass
public abstract class ProjetoPlantioArea extends AppBaseEntity{
	
	@OneToMany (targetEntity = br.net.proex.entity.ope.EtapasProjetoPlantioAreaEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="projetoPlantioArea")
	@ForeignKey(name="FK_ETAPASPROJETOPLANTIOAREA_PROJETOPLANTIOAREA")
	@PlcValDuplicity(property="etapaProjetoPlantio")
	@PlcValMultiplicity(referenceProperty="etapaProjetoPlantio",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.EtapasProjetoPlantioAreaEntity}")
	@Valid
	private List<EtapasProjetoPlantioAreaEntity> etapasProjetoPlantioArea;

	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_projeto_plantio_area")
	private Long id;
		
	@ManyToOne (targetEntity = CadPropriedadeAreaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_PROJETOPLANTIOAREA_AREA")
	@NotNull
	private CadPropriedadeAreaEntity area;
		
	@Enumerated(EnumType.STRING)	
	@Column(length=3)
	private OpeSistemaPlantio sistemaPlantio;
		
	@Digits(integer=8, fraction=2)
	private BigDecimal volumePulverizador;
		
	@Digits(integer=8, fraction=2)
	private BigDecimal vazaoHa;
		
	@Enumerated(EnumType.STRING)	
	@Column(length=3)
	private OpeSistemaHidrico sistemaHidrico;
	
	@Digits(integer=5, fraction=0)
	private Integer anoPlantio;
	
	@Enumerated(EnumType.STRING)
	@Column(length=3)
	private CadMeses previsaoPlantio;
	
	@Digits(integer=8, fraction=2)
	private BigDecimal espacamentoPlantio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public CadPropriedadeAreaEntity getArea() {
		return area;
	}

	public void setArea(CadPropriedadeAreaEntity area) {
		this.area=area;
	}

	public OpeSistemaPlantio getSistemaPlantio() {
		return sistemaPlantio;
	}

	public void setSistemaPlantio(OpeSistemaPlantio sistemaPlantio) {
		this.sistemaPlantio=sistemaPlantio;
	}

	public BigDecimal getVolumePulverizador() {
		return volumePulverizador;
	}

	public void setVolumePulverizador(BigDecimal volumePulverizador) {
		this.volumePulverizador=volumePulverizador;
	}

	public BigDecimal getVazaoHa() {
		return vazaoHa;
	}

	public void setVazaoHa(BigDecimal vazaoHa) {
		this.vazaoHa=vazaoHa;
	}

	public OpeSistemaHidrico getSistemaHidrico() {
		return sistemaHidrico;
	}

	public void setSistemaHidrico(OpeSistemaHidrico sistemaHidrico) {
		this.sistemaHidrico=sistemaHidrico;
	}

	public Integer getAnoPlantio() {
		return anoPlantio;
	}

	public void setAnoPlantio(Integer anoPlantio) {
		this.anoPlantio=anoPlantio;
	}

	public CadMeses getPrevisaoPlantio() {
		return previsaoPlantio;
	}

	public void setPrevisaoPlantio(CadMeses previsaoPlantio) {
		this.previsaoPlantio=previsaoPlantio;
	}

	public BigDecimal getEspacamentoPlantio() {
		return espacamentoPlantio;
	}

	public void setEspacamentoPlantio(BigDecimal espacamentoPlantio) {
		this.espacamentoPlantio=espacamentoPlantio;
	}

	public List<EtapasProjetoPlantioAreaEntity> getEtapasProjetoPlantioArea() {
		return etapasProjetoPlantioArea;
	}

	public void setEtapasProjetoPlantioArea(List<EtapasProjetoPlantioAreaEntity> etapasProjetoPlantioArea) {
		this.etapasProjetoPlantioArea=etapasProjetoPlantioArea;
	}

}
