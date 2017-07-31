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
@Table(name="cad_produto")
@SequenceGenerator(name="se_cad_produto", sequenceName="se_cad_produto")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="CadProdutoEntity.queryMan", query="from CadProdutoEntity"),
	@NamedQuery(name="CadProdutoEntity.querySel", query="select id as id, nome as nome, empresa as empresa from CadProdutoEntity order by nome asc"),
	@NamedQuery(name="CadProdutoEntity.querySelLookup", query="select id as id, nome as nome from CadProdutoEntity where id = ? order by id asc")
})
public class CadProdutoEntity extends CadProduto {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public CadProdutoEntity() {
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
		CadProduto other = (CadProduto) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
