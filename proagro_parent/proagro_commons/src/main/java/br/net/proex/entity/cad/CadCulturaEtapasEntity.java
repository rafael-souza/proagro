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
@Table(name="cad_cultura_etapas")
@SequenceGenerator(name="se_cad_cultura_etapas", sequenceName="se_cad_cultura_etapas")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="CadCulturaEtapasEntity.querySelLookup", query="select id as id, etapa as etapa from CadCulturaEtapasEntity where id = ? order by id asc")
})
public class CadCulturaEtapasEntity extends CadCulturaEtapas {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadCulturaEtapasEntity() {
    }
	@Override
	public String toString() {
		return getEtapa().toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadCulturaEtapas other = (CadCulturaEtapas) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
