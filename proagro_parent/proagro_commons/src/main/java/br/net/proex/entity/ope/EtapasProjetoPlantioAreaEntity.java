package br.net.proex.entity.ope;


import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import javax.persistence.SequenceGenerator;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Access;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="etapas_projeto_plantio_area")
@SequenceGenerator(name="se_etapas_projeto_plantio_area", sequenceName="se_etapas_projeto_plantio_area")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="EtapasProjetoPlantioAreaEntity.querySel", query="select id as id from EtapasProjetoPlantioAreaEntity order by id asc"),
	@NamedQuery(name="EtapasProjetoPlantioAreaEntity.queryMan", query="from EtapasProjetoPlantioAreaEntity"),
	@NamedQuery(name="EtapasProjetoPlantioAreaEntity.querySelLookup", query="select id as id from EtapasProjetoPlantioAreaEntity where id = ? order by id asc")
})
public class EtapasProjetoPlantioAreaEntity extends EtapasProjetoPlantioArea {

	private transient String estadoSubDetalhePlc="E"; // E-expandido, R-retraido

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public EtapasProjetoPlantioAreaEntity() {
    }
	@Override
	public String toString() {
		return getEtapaProjetoPlantio().toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EtapasProjetoPlantioArea other = (EtapasProjetoPlantioArea) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public String getEstadoSubDetalhePlc() {
		return estadoSubDetalhePlc;
	}

	public void setEstadoSubDetalhePlc(String estadoSubDetalhePlc) {
		this.estadoSubDetalhePlc=estadoSubDetalhePlc;
	}

}
