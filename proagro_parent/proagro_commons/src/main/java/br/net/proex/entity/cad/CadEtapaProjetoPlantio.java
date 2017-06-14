package br.net.proex.entity.cad;

import br.net.proex.entity.AppBaseEntity;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import com.powerlogic.jcompany.config.domain.PlcReference;
import javax.persistence.Id;
import javax.persistence.Transient;

@Audited
@MappedSuperclass
public abstract class CadEtapaProjetoPlantio extends AppBaseEntity {
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_etapa_projeto_plantio")
	private Long id;
	
	@NotNull
	@Size(max = 150)
	@PlcReference(testDuplicity=true)
	private String nome;

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

	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
