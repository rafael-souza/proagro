package br.net.proex.controller.jsf.ope;

import java.util.ArrayList;
import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.injectionpoint.HttpParam;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.cad.CadCulturaEntity;
import br.net.proex.entity.cad.CadCulturaEtapasEntity;
import br.net.proex.entity.cad.CadPropriedadeAreaEntity;
import br.net.proex.entity.ope.EtapasProjetoPlantioArea;
import br.net.proex.entity.ope.EtapasProjetoPlantioAreaEntity;
import br.net.proex.entity.ope.ProjetoPlantioAreaEntity;
import br.net.proex.facade.IAppFacade;

@PlcConfigAggregation(
		entity = br.net.proex.entity.ope.ProjetoPlantioAreaEntity.class,details = {
				@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
						clazz = br.net.proex.entity.ope.EtapasProjetoPlantioAreaEntity.class,
						collectionName = "etapasProjetoPlantioArea", numNew = 1,onDemand = false)})
@PlcConfigForm (	
	formPattern=FormPattern.Mdt,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/projetoplantioarea"))


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("projetoplantioarea")
@PlcHandleException
public class ProjetoPlantioAreaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	@Inject	@HttpParam("idArea")
	private String idArea;
	
	@Inject @QPlcDefault
	private IAppFacade facade;
	
	private String urlProximoPasso;
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("projetoplantioarea")
	public ProjetoPlantioAreaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new ProjetoPlantioAreaEntity();
              this.newEntity();
              
              // buscando a área para criação das etapas do projeto de plantio de acordo com a cultura
              ProjetoPlantioAreaEntity projetoPlantio = (ProjetoPlantioAreaEntity)this.entityPlc;              
              if (null == projetoPlantio.getId()){
            	  
            	  CadPropriedadeAreaEntity area = facade.findAreaById(contextMontaUtil.createContextParamMinimum(), idArea);
            	  projetoPlantio.setArea(area);
            	  CadCulturaEntity cultura = facade.findCulturaById(contextMontaUtil.createContextParamMinimum(), area.getCultura().getId());
            	  // percorrendo as etapas selecionadas para a cultura e adicionando no detalhe
            	  if (null != cultura.getCulturaEtapas() && cultura.getCulturaEtapas().size() > 0){
            		  projetoPlantio.setEtapasProjetoPlantioArea(new ArrayList<EtapasProjetoPlantioAreaEntity>());
            		  for (CadCulturaEtapasEntity culturaEtapa : cultura.getCulturaEtapas()){            			  
            			  EtapasProjetoPlantioAreaEntity etapaProjetoPlantio = new EtapasProjetoPlantioAreaEntity();            			  
            			  etapaProjetoPlantio.setEtapaProjetoPlantio(culturaEtapa.getEtapa());
            			  etapaProjetoPlantio.setProjetoPlantioArea(projetoPlantio);
            			  projetoPlantio.getEtapasProjetoPlantioArea().add(etapaProjetoPlantio);
            		  }
            	  }            	              	 
              }
              
              setUrlProximoPasso("");
              
        }
        return (ProjetoPlantioAreaEntity)this.entityPlc;     	
	}
	
	/**
	 * 
	 */
	@Override
	public void handleButtonsAccordingFormPattern() {
		super.handleButtonsAccordingFormPattern();
		Map<String, Object> requestMap = contextUtil.getRequestMap();
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_INCLUIR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_ABRIR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_CLONAR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_EXCLUIR, PlcConstants.NAO_EXIBIR);
	}	
	
	/**
	 * Verifica em qual etapa está para alimentar a urlProximoPasso
	 */
	public void proximoPasso(){
        ProjetoPlantioAreaEntity projetoPlantio = (ProjetoPlantioAreaEntity)this.entityPlc;
        setUrlProximoPasso("");
        if (null != projetoPlantio.getEtapasProjetoPlantioArea() && projetoPlantio.getEtapasProjetoPlantioArea().size() > 0){
        	for (EtapasProjetoPlantioArea etapaProjetPlantio : projetoPlantio.getEtapasProjetoPlantioArea()){
        		// verificando se a etapa está concluída
        		if (null != etapaProjetPlantio.getEtapaConcluida() && !etapaProjetPlantio.getEtapaConcluida()){
        			
        			switch (etapaProjetPlantio.getEtapaProjetoPlantio().getTipo()) {
					case DESS:
						// caso a etapa for dessecação
						setUrlProximoPasso("/f/n/etapadessecacaomdt?id=" + etapaProjetPlantio.getId());
						break;
					default:
						break;
					}
          		}
        		
        		if (!getUrlProximoPasso().isEmpty()){
        			return;
        		}
        	}
        }
		
	}

	/**
	 * @return the idArea
	 */
	public String getIdArea() {
		return idArea;
	}

	/**
	 * @param idArea the idArea to set
	 */
	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getUrlProximoPasso() {
		return urlProximoPasso;
	}

	public void setUrlProximoPasso(String urlProximoPasso) {
		this.urlProximoPasso = urlProximoPasso;
	}
		
}
