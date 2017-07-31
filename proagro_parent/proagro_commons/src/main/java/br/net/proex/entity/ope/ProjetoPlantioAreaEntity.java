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
@Table(name="projeto_plantio_area")
@SequenceGenerator(name="se_projeto_plantio_area", sequenceName="se_projeto_plantio_area")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="ProjetoPlantioAreaEntity.queryMan", query="from ProjetoPlantioAreaEntity"),
	@NamedQuery(name="ProjetoPlantioAreaEntity.buscaProjetoPlantioArea", 
		query="select obj from ProjetoPlantioAreaEntity obj "
				+ "left outer join obj.area obj2 "
				+ "where obj.id = :idArea "),
	@NamedQuery(name="ProjetoPlantioAreaEntity.querySelLookup", query="select id as id, area as area from ProjetoPlantioAreaEntity where id = ? order by id asc")
})
public class ProjetoPlantioAreaEntity extends ProjetoPlantioArea {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public ProjetoPlantioAreaEntity() {
    }
	@Override
	public String toString() {
		if (null != getArea()){
			return getArea().toString();
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
		ProjetoPlantioArea other = (ProjetoPlantioArea) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
