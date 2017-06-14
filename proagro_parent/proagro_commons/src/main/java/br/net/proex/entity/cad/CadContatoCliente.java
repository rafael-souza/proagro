package br.net.proex.entity.cad;

import br.net.proex.entity.AppBaseEntity;
import br.net.proex.enumeration.CadTipoContato;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.validation.constraints.NotNull;
import javax.persistence.EnumType;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;
import javax.persistence.Transient;

/**
 * 
 * @author rafael
 *
 */
@Audited
@MappedSuperclass
public abstract class CadContatoCliente extends AppBaseEntity {
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_contato_cliente")
	private Long id;
	
	@ManyToOne (targetEntity = CadClienteEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_CADCONTATOCLIENTE_CLIENTE")
	@NotNull
	private CadClienteEntity cliente;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@PlcValRequiredIf(dependentfield="tipoContato",targetField="descricao")
	@Column(length=3)
	private CadTipoContato tipoContato;
		
	@NotNull	
	@Size(max = 50)
	private String descricao;
				
	@Size(max = 100)
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public CadTipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(CadTipoContato tipoContato) {
		this.tipoContato=tipoContato;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao=descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao=observacao;
	}

	public CadClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(CadClienteEntity cliente) {
		this.cliente=cliente;
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
