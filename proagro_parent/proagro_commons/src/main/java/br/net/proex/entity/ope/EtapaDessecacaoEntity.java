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
@Table(name="etapa_dessecacao")
@SequenceGenerator(name="se_etapa_dessecacao", sequenceName="se_etapa_dessecacao")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="EtapaDessecacaoEntity.querySelLookup", query="select id as id, produto as produto from EtapaDessecacaoEntity where id = ? order by id asc")
})
public class EtapaDessecacaoEntity extends EtapaDessecacao {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public EtapaDessecacaoEntity() {
    }
	@Override
	public String toString() {
		if (null != getProduto()){
			return getProduto().toString();
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
		EtapaDessecacao other = (EtapaDessecacao) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
