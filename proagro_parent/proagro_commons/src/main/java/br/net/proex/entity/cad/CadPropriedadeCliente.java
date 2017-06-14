package br.net.proex.entity.cad;

import br.net.proex.entity.AppBaseEntity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 
 * @author rafael
 *
 */
@Audited
@MappedSuperclass
public abstract class CadPropriedadeCliente extends AppBaseEntity {
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_propriedade_cliente")
	private Long id;
	
	@ManyToOne (targetEntity = CadClienteEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_CADPROPRIEDADECLIENTE_CADCLIENTE")
	@NotNull
	private CadClienteEntity cliente;
	
	@ManyToOne (targetEntity = CadPropriedadeEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_CADPROPRIEDADECLIENTE_PROPRIEDADE")
	@NotNull
	private CadPropriedadeEntity propriedade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public CadPropriedadeEntity getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(CadPropriedadeEntity propriedade) {
		this.propriedade=propriedade;
	}

	/**
	 * @return the cliente
	 */
	public CadClienteEntity getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(CadClienteEntity cliente) {
		this.cliente = cliente;
	}
	
	
	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}	

}
