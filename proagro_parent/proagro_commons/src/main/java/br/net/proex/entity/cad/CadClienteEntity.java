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
@Table(name="cad_cliente")
@SequenceGenerator(name="se_cad_cliente", sequenceName="se_cad_cliente")
@Access(AccessType.FIELD)
@Audited

@NamedQueries({
	@NamedQuery(name="CadClienteEntity.queryMan", query="from CadClienteEntity"),
	@NamedQuery(name="CadClienteEntity.querySel", query="select obj.id as id, obj.nome as nome, obj.endereco.logradouro as endereco_logradouro, obj.endereco.numero as endereco_numero, obj1.id as endereco_cidade_id , obj1.nome as endereco_cidade_nome from CadClienteEntity obj left outer join obj.endereco.cidade as obj1 order by obj.nome asc"),
	@NamedQuery(name="CadClienteEntity.querySelLookup", query="select id as id, nome as nome from CadClienteEntity where id = ? order by id asc")
})
public class CadClienteEntity extends CadCliente {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadClienteEntity() {
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
		CadCliente other = (CadCliente) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
