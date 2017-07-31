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
@Table(name="cad_contato_cliente")
@SequenceGenerator(name="se_cad_contato_cliente", sequenceName="se_cad_contato_cliente")
@Access(AccessType.FIELD)
@Audited

@NamedQueries({
	@NamedQuery(name="CadContatoClienteEntity.querySelLookup", query="select id as id, descricao as descricao from CadContatoClienteEntity where id = ? order by id asc")
})
public class CadContatoClienteEntity extends CadContatoCliente {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadContatoClienteEntity() {
    }
	@Override
	public String toString() {
		if (null != getDescricao()){
			return getDescricao();
		}
		
		return "";			
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadContatoCliente other = (CadContatoCliente) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
