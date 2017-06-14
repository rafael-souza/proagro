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
@Table(name="cad_propriedade_cliente")
@SequenceGenerator(name="se_cad_propriedade_cliente", sequenceName="se_cad_propriedade_cliente")
@Access(AccessType.FIELD)

@Audited
@NamedQueries({
	@NamedQuery(name="CadPropriedadeClienteEntity.querySelLookup", query="select id as id, propriedade as propriedade from CadPropriedadeClienteEntity where id = ? order by id asc")
})
public class CadPropriedadeClienteEntity extends CadPropriedadeCliente {

	private transient String propriedadeAuxLookup;


	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadPropriedadeClienteEntity() {
    }
	@Override
	public String toString() {
		return getPropriedade().toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadPropriedadeCliente other = (CadPropriedadeCliente) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}


	public void setPropriedadeAuxLookup(String propriedadeAuxLookup) {
		this.propriedadeAuxLookup=propriedadeAuxLookup;
	}

}
