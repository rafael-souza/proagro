package br.net.proex.controller.jsf.cad;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.cad.CadPropriedadeAreaEntity;
import br.net.proex.entity.cad.CadPropriedadeEntity;
import br.net.proex.entity.ope.ProjetoPlantioAreaEntity;
import br.net.proex.facade.IAppFacade;

@PlcConfigAggregation(
		entity = br.net.proex.entity.cad.CadPropriedadeEntity.class
		,components = {@com.powerlogic.jcompany.config.aggregation.PlcConfigComponent(clazz=br.net.proex.commons.component.CadEndereco.class, property="endereco", separate=false)}
		,details = {@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(clazz = br.net.proex.entity.cad.CadPropriedadeAreaEntity.class,
								collectionName = "propriedadeArea", numNew = 1,onDemand = false)
		}
	)
@PlcConfigForm (	
	formPattern=FormPattern.Mad,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/cadpropriedadearea")
	
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("cadpropriedadearea")
@PlcHandleException
public class CadPropriedadeAreaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	@Inject @QPlcDefault
	private IAppFacade facade;
	
	private Long idProjetoPlantio;
	
	private String idArea;
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("cadpropriedadearea")
	public CadPropriedadeEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new CadPropriedadeEntity(); 
              this.newEntity();              
        }
        return (CadPropriedadeEntity)this.entityPlc;     	
	}
	
	@Override
	public String edit() {
		String retorno = super.edit();
        // buscando os clientes da propriedade
        ((CadPropriedadeEntity)this.entityPlc).setClientes(facade.buscarClientePropriedade(
      		  contextMontaUtil.createContextParamMinimum(), ((CadPropriedadeEntity)this.entityPlc).getId()));		
		return retorno;
	}
	
	/**
	 * 
	 */
	public void verificaProjetoPlantio(){
		ProjetoPlantioAreaEntity projetoPlantio = new ProjetoPlantioAreaEntity();		
		projetoPlantio = facade.buscaProjetoPlantioArea(contextMontaUtil.createContextParamMinimum(), Long.valueOf(getIdArea()));		
		if (null != projetoPlantio){
			setIdProjetoPlantio(projetoPlantio.getId());
		}
		
	}

	public Long getIdProjetoPlantio() {
		return idProjetoPlantio;
	}

	public void setIdProjetoPlantio(Long idProjetoPlantio) {
		this.idProjetoPlantio = idProjetoPlantio;
	}

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}
		
}

