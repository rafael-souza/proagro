package br.net.proex.entity.cad;

import br.net.proex.entity.AppBaseEntity;
import br.net.proex.enumeration.TipoEtapaProjetoPlantio;
import br.net.proex.enumeration.TipoCultura;

import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import com.powerlogic.jcompany.config.domain.PlcReference;
import javax.persistence.Id;
import javax.persistence.Transient;

@Audited
@MappedSuperclass
public abstract class CadEtapaProjetoPlantio extends AppBaseEntity {
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_etapa_projeto_plantio")
	private Long id;
		
	@Enumerated(EnumType.STRING)
	@PlcReference(testDuplicity=true)
	@Column(length=4)
	private TipoEtapaProjetoPlantio tipo;	
	
	@NotNull
	@Size(max = 150)	
	private String descricao;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
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
	 * @return the tipo
	 */
	public TipoEtapaProjetoPlantio getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoEtapaProjetoPlantio tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
