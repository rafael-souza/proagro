package br.net.proex.entity.cad;

import br.net.proex.entity.AppBaseEntity;
import br.net.proex.enumeration.TipoCultura;
import javax.persistence.EnumType;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import java.util.List;
import javax.validation.Valid;
import javax.persistence.CascadeType;
import org.hibernate.annotations.ForeignKey;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;

@Audited
@MappedSuperclass
public abstract class CadCultura extends AppBaseEntity{

	
	@OneToMany (targetEntity = br.net.proex.entity.cad.CadCulturaEtapasEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="cultura")
	@ForeignKey(name="FK_CADCULTURAETAPAS_CADCULTURA")
	@PlcValDuplicity(property="etapa")
	@PlcValMultiplicity(referenceProperty="etapa",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.CadCulturaEtapasEntity}")
	@Valid
	private List<CadCulturaEtapasEntity> culturaEtapas;


	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_cultura")
	private Long id;
	
	
	@NotNull
	@Size(max = 60)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(length=3)
	private TipoCultura tipo;

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

	public TipoCultura getTipo() {
		return tipo;
	}

	public void setTipo(TipoCultura tipo) {
		this.tipo=tipo;
	}

	public List<CadCulturaEtapasEntity> getCulturaEtapas() {
		return culturaEtapas;
	}

	public void setCulturaEtapas(List<CadCulturaEtapasEntity> culturaEtapas) {
		this.culturaEtapas=culturaEtapas;
	}

}
