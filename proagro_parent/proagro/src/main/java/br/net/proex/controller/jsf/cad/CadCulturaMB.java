package br.net.proex.controller.jsf.cad;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.cad.CadCulturaEntity;

@PlcConfigAggregation(
		entity = br.net.proex.entity.cad.CadCulturaEntity.class,
		details = {@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
				clazz = br.net.proex.entity.cad.CadCulturaEtapasEntity.class,
				collectionName = "culturaEtapas", numNew = 1,onDemand = false)})
@PlcConfigForm (	
	formPattern=FormPattern.Mdt,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/cadcultura")
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("cadcultura")
@PlcHandleException
public class CadCulturaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("cadcultura")
	public CadCulturaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new CadCulturaEntity();
              this.newEntity();
        }
        return (CadCulturaEntity)this.entityPlc;     	
	}
		
}
