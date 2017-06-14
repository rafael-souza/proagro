package br.net.proex.entity.cad;


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
@Table(name="cad_etapa_projeto_plantio")
@SequenceGenerator(name="se_cad_etapa_projeto_plantio", sequenceName="se_cad_etapa_projeto_plantio")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="CadEtapaProjetoPlantioEntity.queryMan", query="from CadEtapaProjetoPlantioEntity"),
	@NamedQuery(name="CadEtapaProjetoPlantioEntity.querySelLookup", query="select id as id, nome as nome from CadEtapaProjetoPlantioEntity where id = ? order by id asc")
})
public class CadEtapaProjetoPlantioEntity extends CadEtapaProjetoPlantio {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadEtapaProjetoPlantioEntity() {
    }
	@Override
	public String toString() {
		return getNome();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadEtapaProjetoPlantio other = (CadEtapaProjetoPlantio) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
