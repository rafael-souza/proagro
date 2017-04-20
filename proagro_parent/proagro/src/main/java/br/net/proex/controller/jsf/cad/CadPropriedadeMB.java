package br.net.proex.controller.jsf.cad;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import br.net.proex.entity.cad.CadPropriedadeEntity;
import br.net.proex.controller.jsf.AppMB;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;



 
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = br.net.proex.entity.cad.CadPropriedadeEntity.class
		

		,components = {@com.powerlogic.jcompany.config.aggregation.PlcConfigComponent(clazz=br.net.proex.commons.component.CadEndereco.class, property="endereco", separate=true)}
	)
	


@PlcConfigForm (
	
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/cadpropriedade")
	
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("cadpropriedade")
@PlcHandleException
public class CadPropriedadeMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("cadpropriedade")
	public CadPropriedadeEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new CadPropriedadeEntity();
              this.newEntity();
        }
        return (CadPropriedadeEntity)this.entityPlc;     	
	}
		
}
