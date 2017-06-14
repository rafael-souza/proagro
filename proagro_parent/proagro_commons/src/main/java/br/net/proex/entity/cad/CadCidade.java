package br.net.proex.entity.cad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import br.net.proex.entity.AppBaseEntity;
import br.net.proex.enumeration.CadUf;

/**
 * Cadastro das cidades
 * @author rafael
 *
 *
 */
@Audited
@MappedSuperclass
public abstract class CadCidade extends AppBaseEntity implements Serializable {
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_cidade")
	private Long id;
	
	
	@NotNull
	@Size(max = 60)
	private String nome;
		
	@NotNull
	private Integer codigoIbge;
	
	@NotNull
	@Enumerated(EnumType.STRING)	
	@Column(length=2)
	private CadUf uf;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public Integer getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(Integer codigoIbge) {
		this.codigoIbge=codigoIbge;
	}

	public CadUf getUf() {
		return uf;
	}

	public void setUf(CadUf uf) {
		this.uf=uf;
	}

}
