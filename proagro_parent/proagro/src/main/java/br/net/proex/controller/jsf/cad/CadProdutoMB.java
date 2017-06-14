package br.net.proex.controller.jsf.cad;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import br.net.proex.entity.cad.CadProdutoEntity;
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
		entity = br.net.proex.entity.cad.CadProdutoEntity.class
		
	)
	


@PlcConfigForm (
	
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/cadproduto")
	
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("cadproduto")
@PlcHandleException
public class CadProdutoMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("cadproduto")
	public CadProdutoEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new CadProdutoEntity();
              this.newEntity();
        }
        return (CadProdutoEntity)this.entityPlc;     	
	}
		
}
