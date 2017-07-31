package br.net.proex.entity.ope;

import br.net.proex.entity.AppBaseEntity;
import br.net.proex.entity.cad.CadEtapaProjetoPlantioEntity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;
import javax.validation.Valid;
import javax.persistence.CascadeType;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.OneToMany;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;

@Audited
@MappedSuperclass
public abstract class EtapasProjetoPlantioArea extends AppBaseEntity{

	
	@OneToMany (targetEntity = br.net.proex.entity.ope.EtapaDessecacaoEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="etapasProjetoPlantioArea")
	@ForeignKey(name="FK_DESSECACAO_ETAPASPROJETOPLANTIOAREA")
	@PlcValDuplicity(property="produto")
	@PlcValMultiplicity(referenceProperty="produto",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.DessecacaoEntity}")
	@Valid
	private List<EtapaDessecacaoEntity> etapaDessecacao;
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_etapas_projeto_plantio_area")
	private Long id;
	
	@ManyToOne (targetEntity = ProjetoPlantioAreaEntity.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE })
	@ForeignKey(name="FK_ETAPASPROJETOPLANTIOAREA_PROJETOPLANTIOAREA")
	@NotNull
	private ProjetoPlantioAreaEntity projetoPlantioArea;

	
	@ManyToOne (targetEntity = CadEtapaProjetoPlantioEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_ETAPASPROJETOPLANTIOAREA_ETAPAPROJETOPLANTIO")
	@NotNull
	private CadEtapaProjetoPlantioEntity etapaProjetoPlantio;
	
	private Boolean etapaConcluida;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public CadEtapaProjetoPlantioEntity getEtapaProjetoPlantio() {
		return etapaProjetoPlantio;
	}

	public void setEtapaProjetoPlantio(CadEtapaProjetoPlantioEntity etapaProjetoPlantio) {
		this.etapaProjetoPlantio=etapaProjetoPlantio;
	}

	public ProjetoPlantioAreaEntity getProjetoPlantioArea() {
		return projetoPlantioArea;
	}

	public void setProjetoPlantioArea(ProjetoPlantioAreaEntity projetoPlantioArea) {
		this.projetoPlantioArea=projetoPlantioArea;
	}

	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

	/**
	 * @return the etapaConcluida
	 */
	public Boolean getEtapaConcluida() {
		return etapaConcluida;
	}

	/**
	 * @param etapaConcluida the etapaConcluida to set
	 */
	public void setEtapaConcluida(Boolean etapaConcluida) {
		this.etapaConcluida = etapaConcluida;
	}

	public List<EtapaDessecacaoEntity> getEtapaDessecacao() {
		return etapaDessecacao;
	}

	public void setEtapaDessecacao(List<EtapaDessecacaoEntity> etapaDessecacao) {
		this.etapaDessecacao=etapaDessecacao;
	}

}
