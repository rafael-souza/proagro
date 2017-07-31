package br.net.proex.entity.ope;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;

import br.net.proex.entity.AppBaseEntity;
import br.net.proex.entity.cad.CadProdutoEntity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.persistence.FetchType;
import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;
import javax.persistence.Id;
import javax.persistence.Transient;

@Audited
@MappedSuperclass
public abstract class EtapaDessecacao extends AppBaseEntity {
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_etapa_dessecacao")
	private Long id;
	
	@ManyToOne (targetEntity = EtapasProjetoPlantioAreaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_DESSECACAO_ETAPASPROJETOPLANTIOAREA")
	@NotNull
	private EtapasProjetoPlantioAreaEntity etapasProjetoPlantioArea;

	@ManyToOne (targetEntity = CadProdutoEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_DESSECACAO_PRODUTO")
	@NotNull(groups=PlcValGroupEntityList.class)
	private CadProdutoEntity produto;
	
	@NotNull(groups=PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="doseHa",targetField="produto")
	@Digits(integer=8, fraction=2)
	private BigDecimal doseHa;
	
	@NotNull(groups=PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="dosePulverizador",targetField="produto")
	@Digits(integer=8, fraction=2)
	private BigDecimal dosePulverizador;
	
	@NotNull(groups=PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="total",targetField="produto")
	@Digits(integer=8, fraction=2)
	private BigDecimal total;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public CadProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(CadProdutoEntity produto) {
		this.produto=produto;
	}

	public BigDecimal getDoseHa() {
		return doseHa;
	}

	public void setDoseHa(BigDecimal doseHa) {
		this.doseHa=doseHa;
	}

	public BigDecimal getDosePulverizador() {
		return dosePulverizador;
	}

	public void setDosePulverizador(BigDecimal dosePulverizador) {
		this.dosePulverizador=dosePulverizador;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total=total;
	}

	public EtapasProjetoPlantioAreaEntity getEtapasProjetoPlantioArea() {
		return etapasProjetoPlantioArea;
	}

	public void setEtapasProjetoPlantioArea(EtapasProjetoPlantioAreaEntity etapasProjetoPlantioArea) {
		this.etapasProjetoPlantioArea=etapasProjetoPlantioArea;
	}

	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
