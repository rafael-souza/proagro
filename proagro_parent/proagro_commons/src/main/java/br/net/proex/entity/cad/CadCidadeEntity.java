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
@Table(name="cad_cidade")
@SequenceGenerator(name="se_cad_cidade", sequenceName="se_cad_cidade")
@Access(AccessType.FIELD)
@Audited

@NamedQueries({
	@NamedQuery(name="CadCidadeEntity.queryMan", query="from CadCidadeEntity"),
	@NamedQuery(name="CadCidadeEntity.querySel", query="select id as id, nome as nome, codigoIbge as codigoIbge, uf as uf from CadCidadeEntity order by nome asc"),
	@NamedQuery(name="CadCidadeEntity.querySelLookup", query="select id as id, nome as nome from CadCidadeEntity where id = ? order by id asc")
})
public class CadCidadeEntity extends CadCidade {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadCidadeEntity() {
    }
    
	@Override
	public String toString() {
		if (null != getNome()){
			return getNome();
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
		CadCidade other = (CadCidade) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
