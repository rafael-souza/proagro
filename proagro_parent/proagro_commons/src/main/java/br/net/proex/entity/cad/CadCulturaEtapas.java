package br.net.proex.entity.cad;

import br.net.proex.entity.AppBaseEntity;
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

@Audited
@MappedSuperclass
public abstract class CadCulturaEtapas extends AppBaseEntity{
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_cultura_etapas")
	private Long id;
	
	@ManyToOne (targetEntity = CadCulturaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_CADCULTURAETAPAS_CADCULTURA")
	@NotNull
	private CadCulturaEntity cultura;
	
	
	@ManyToOne (targetEntity = CadEtapaProjetoPlantioEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_CADCULTURAETAPAS_ETAPA")
	@NotNull
	private CadEtapaProjetoPlantioEntity etapa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public CadEtapaProjetoPlantioEntity getEtapa() {
		return etapa;
	}

	public void setEtapa(CadEtapaProjetoPlantioEntity etapa) {
		this.etapa=etapa;
	}

	public CadCulturaEntity getCultura() {
		return cultura;
	}

	public void setCultura(CadCulturaEntity cultura) {
		this.cultura=cultura;
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
