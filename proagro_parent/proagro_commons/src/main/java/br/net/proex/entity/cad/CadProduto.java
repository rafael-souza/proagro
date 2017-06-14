package br.net.proex.entity.cad;

import br.net.proex.entity.AppBaseEntity;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Audited
@MappedSuperclass
public abstract class CadProduto extends AppBaseEntity {

	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_produto")
	private Long id;

	
	@NotNull
	@Size(max = 150)
	private String empresa;
	
	
	@NotNull
	@Size(max = 100)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa=empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

}
