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
@Table(name="cad_propriedade_area")
@SequenceGenerator(name="se_cad_propriedade_area", sequenceName="se_cad_propriedade_area")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="CadPropriedadeAreaEntity.querySelLookup", query="select id as id, nome as nome from CadPropriedadeAreaEntity where id = ? order by id asc")
})
public class CadPropriedadeAreaEntity extends CadPropriedadeArea {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadPropriedadeAreaEntity() {
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
		CadPropriedadeArea other = (CadPropriedadeArea) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
