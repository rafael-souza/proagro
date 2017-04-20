package br.net.proex.entity.cad;

import java.util.Date;

import com.powerlogic.jcompany.domain.validation.PlcValCpf;

import br.net.proex.commons.component.CadEndereco;
import br.net.proex.entity.AppBaseEntity;
import javax.validation.Valid;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.MappedSuperclass;
import javax.persistence.TemporalType;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.CascadeType;
import org.hibernate.annotations.ForeignKey;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;

/**
 * 
 * @author rafael
 *
 */
@MappedSuperclass
public abstract class CadCliente extends AppBaseEntity {

	@OneToMany (targetEntity = br.net.proex.entity.cad.CadPropriedadeClienteEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="cliente")
	@ForeignKey(name="FK_CADPROPRIEDADECLIENTE_CADCLIENTE")
	@PlcValDuplicity(property="propriedade")
	@PlcValMultiplicity(referenceProperty="propriedade",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.CadPropriedadeClienteEntity}")
	@Valid
	private List<CadPropriedadeClienteEntity> propriedadeCliente;
	
	@OneToMany (targetEntity = br.net.proex.entity.cad.CadContatoClienteEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="cliente")
	@ForeignKey(name="FK_CADCONTATOCLIENTE_CADCLIENTE")
	@PlcValDuplicity(property="descricao")
	@PlcValMultiplicity(referenceProperty="descricao",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.CadContatoClienteEntity}")
	@Valid
	private List<CadContatoClienteEntity> contatoCliente;

	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_cliente")
	private Long id;	
	
	@NotNull
	@Size(max = 120)
	private String nome;
			
	@PlcValCpf
	private String cpf;
			
	@Size(max = 16)
	private String rg;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
		
	@Embedded	
	@Valid
	private CadEndereco endereco;
	
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf=cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg=rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento=dataNascimento;
	}

	public CadEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(CadEndereco endereco) {
		this.endereco=endereco;
	}

	public List<CadContatoClienteEntity> getContatoCliente() {
		return contatoCliente;
	}

	public void setContatoCliente(List<CadContatoClienteEntity> contatoCliente) {
		this.contatoCliente=contatoCliente;
	}

	/**
	 * @return the propriedadeCliente
	 */
	public List<CadPropriedadeClienteEntity> getPropriedadeCliente() {
		return propriedadeCliente;
	}

	/**
	 * @param propriedadeCliente the propriedadeCliente to set
	 */
	public void setPropriedadeCliente(List<CadPropriedadeClienteEntity> propriedadeCliente) {
		this.propriedadeCliente = propriedadeCliente;
	}



}
