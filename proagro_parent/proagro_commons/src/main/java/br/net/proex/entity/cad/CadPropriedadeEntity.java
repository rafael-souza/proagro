package br.net.proex.entity.cad;


import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Access;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="cad_propriedade")
@SequenceGenerator(name="se_cad_propriedade", sequenceName="se_cad_propriedade")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="CadPropriedadeEntity.queryMan", query="from CadPropriedadeEntity"),
	@NamedQuery(name="CadPropriedadeEntity.querySel", query="select obj.id as id, obj.nome as nome, obj.areaTotal as areaTotal, obj.endereco.logradouro as endereco_logradouro, obj.endereco.numero as endereco_numero, obj1.id as endereco_cidade_id , obj1.nome as endereco_cidade_nome from CadPropriedadeEntity obj left outer join obj.endereco.cidade as obj1 order by obj.nome asc"),
	@NamedQuery(name="CadPropriedadeEntity.querySelLookup", query="select id as id, nome as nome from CadPropriedadeEntity where id = ? order by id asc")
})
public class CadPropriedadeEntity extends CadPropriedade {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadPropriedadeEntity() {
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
		CadPropriedade other = (CadPropriedade) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
