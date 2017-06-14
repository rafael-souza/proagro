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
@Table(name="cad_cultura")
@SequenceGenerator(name="se_cad_cultura", sequenceName="se_cad_cultura")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="CadCulturaEntity.querySel2", query="select id as id, nome as nome from CadCulturaEntity order by nome asc"),
	@NamedQuery(name="CadCulturaEntity.queryMan", query="from CadCulturaEntity"),
	@NamedQuery(name="CadCulturaEntity.querySel", query="select id as id, nome as nome, tipo as tipo from CadCulturaEntity order by nome asc"),
	@NamedQuery(name="CadCulturaEntity.querySelLookup", query="select id as id, nome as nome from CadCulturaEntity where id = ? order by id asc")
})
public class CadCulturaEntity extends CadCultura {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadCulturaEntity() {
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
		CadCultura other = (CadCultura) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
