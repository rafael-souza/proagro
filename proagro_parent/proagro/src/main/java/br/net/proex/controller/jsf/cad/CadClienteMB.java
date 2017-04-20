package br.net.proex.controller.jsf.cad;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import br.net.proex.entity.cad.CadClienteEntity;
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
		entity = br.net.proex.entity.cad.CadClienteEntity.class,
		components = {@com.powerlogic.jcompany.config.aggregation.PlcConfigComponent(				
				clazz=br.net.proex.commons.component.CadEndereco.class, property="endereco", separate=false)},
		details = {@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(clazz = br.net.proex.entity.cad.CadContatoClienteEntity.class,
				collectionName = "contatoCliente", numNew = 1,onDemand = false),
		@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(clazz = br.net.proex.entity.cad.CadPropriedadeClienteEntity.class,
				collectionName = "propriedadeCliente", numNew = 1,onDemand = false)			
		}
	)
	
@PlcConfigForm (	
	formPattern=FormPattern.Mdt,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/cadcliente")
)


/**
 * Classe de Controle gerada pelo assistente
 */ 
@SPlcMB
@PlcUriIoC("cadcliente")
@PlcHandleException
public class CadClienteMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("cadcliente")
	public CadClienteEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new CadClienteEntity();
              this.newEntity();
        }
        return (CadClienteEntity)this.entityPlc;     	
	}
		
}
