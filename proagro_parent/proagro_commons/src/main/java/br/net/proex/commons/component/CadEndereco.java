package br.net.proex.commons.component;


import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;

import br.net.proex.entity.cad.CadCidadeEntity;

/**
 * Componente para implementação do endereço
 * @author rafael
 *
 */
@Embeddable
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name="CadEndereco.querySelLookup", query="select logradouro as logradouro from CadEndereco where id = ? order by logradouro asc")
})
public class CadEndereco  implements Serializable {
		
	@NotNull
	@Size(max = 120)
	private String logradouro;
			
	@Size(max = 20)
	private String numero;
		
	@Size(max = 40)
	private String complemento;
			
	@Size(max = 120)
	private String bairro;
		
	@Size(max = 10)
	private String cep;
		
	@ManyToOne (targetEntity = CadCidadeEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_CADENDERECO_CIDADE")	
	private CadCidadeEntity cidade;

	public CadEndereco() {
	}
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro=logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero=numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento=complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro=bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep=cep;
	}

	public CadCidadeEntity getCidade() {
		return cidade;
	}

	public void setCidade(CadCidadeEntity cidade) {
		this.cidade=cidade;
	}

	@Override
	public String toString() {
		return getLogradouro();
	}

}
