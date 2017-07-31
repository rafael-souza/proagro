package br.net.proex.entity.cad;

import java.math.BigDecimal;
import java.util.Date;

import br.net.proex.entity.AppBaseEntity;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.FetchType;
import javax.validation.constraints.Digits;
import javax.persistence.Id;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;
import javax.persistence.Transient;

@Audited
@MappedSuperclass
public abstract class CadPropriedadeArea extends AppBaseEntity {
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_cad_propriedade_area")
	private Long id;
	
	@ManyToOne (targetEntity = CadPropriedadeEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_CADAREAPROPRIEDADE_CADPROPRIEDADE")
	@NotNull
	private CadPropriedadeEntity propriedade;

	@NotNull
	@Size(max = 60)
	private String nome;
	
	@ManyToOne (targetEntity = CadCulturaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_CADAREAPROPRIEDADE_CULTURA")
	@NotNull
	@PlcValRequiredIf(dependentfield="cultura",targetField="nome")
	private CadCulturaEntity cultura;
	
	@Digits(integer=8, fraction=2)
	private BigDecimal area;
	
	@Size(max = 20)
	private String altitude;
	
	@Digits(integer=5, fraction=0)
	private Integer ano;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPlantio;
	
	private String poligono;

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

	public CadCulturaEntity getCultura() {
		return cultura;
	}

	public void setCultura(CadCulturaEntity cultura) {
		this.cultura=cultura;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area=area;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude=altitude;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano=ano;
	}

	public Date getDataPlantio() {
		return dataPlantio;
	}

	public void setDataPlantio(Date dataPlantio) {
		this.dataPlantio=dataPlantio;
	}

	public CadPropriedadeEntity getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(CadPropriedadeEntity propriedade) {
		this.propriedade=propriedade;
	}

	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

	/**
	 * @return the poligono
	 */
	public String getPoligono() {
		return poligono;
	}

	/**
	 * @param poligono the poligono to set
	 */
	public void setPoligono(String poligono) {
		this.poligono = poligono;
	}

}
