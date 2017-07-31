package br.net.proex.controller.jsf.ope;

import java.math.BigDecimal;
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
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.ope.EtapaDessecacao;
import br.net.proex.entity.ope.EtapaDessecacaoEntity;
import br.net.proex.entity.ope.EtapasProjetoPlantioAreaEntity;
import br.net.proex.entity.ope.ProjetoPlantioAreaEntity;
import br.net.proex.facade.IAppFacade;

@PlcConfigAggregation(
		entity = br.net.proex.entity.ope.EtapasProjetoPlantioAreaEntity.class,
			details = {@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
					clazz = br.net.proex.entity.ope.EtapaDessecacaoEntity.class,
					collectionName = "etapaDessecacao", numNew = 1,onDemand = false)}
)

@PlcConfigForm (	
	formPattern=FormPattern.Mdt,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/etapadessecacao")
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("etapadessecacao")
@PlcHandleException
public class EtapaDessecacaoMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	@Inject @QPlcDefault
	private IAppFacade facade;
	
	private BigDecimal volumePulverizador;
	
	private BigDecimal vazaoHa;
	
	private BigDecimal totalHaArea;
	
	private ProjetoPlantioAreaEntity projetoPlantioVar;
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("dessecacao")
	public EtapasProjetoPlantioAreaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new EtapasProjetoPlantioAreaEntity();
              this.newEntity();
        }
        return (EtapasProjetoPlantioAreaEntity)this.entityPlc;     	
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
	 * 
	 */
	@Override
	public String edit() {		
		String retorno = super.edit();
		EtapasProjetoPlantioAreaEntity etapaProjetoPlantioArea = (EtapasProjetoPlantioAreaEntity)this.entityPlc;
		
		projetoPlantioVar = facade.buscaProjetoPlantioArea(contextMontaUtil.createContextParamMinimum(), etapaProjetoPlantioArea.getProjetoPlantioArea().getId());
		// armazenando as variaveis para o calculo
		setVolumePulverizador(projetoPlantioVar.getVolumePulverizador());
		setVazaoHa(projetoPlantioVar.getVazaoHa());
		setTotalHaArea(projetoPlantioVar.getArea().getArea());
		return retorno;
	}
	
	@Override
	public String save() {
		String retorno = "";
		EtapasProjetoPlantioAreaEntity etapaProjetoPlantioArea = (EtapasProjetoPlantioAreaEntity)this.entityPlc;
		
		// ajustando os objetos das etpas de dessecação
		if (null != etapaProjetoPlantioArea.getEtapaDessecacao() && etapaProjetoPlantioArea.getEtapaDessecacao().size() > 0){
			for (EtapaDessecacaoEntity etapaDessecacao : etapaProjetoPlantioArea.getEtapaDessecacao()){
				etapaDessecacao.setEtapasProjetoPlantioArea(etapaProjetoPlantioArea);
			}
		}		
		
		retorno =  super.save();
		
		return retorno;
	}

	public BigDecimal getVolumePulverizador() {
		return volumePulverizador;
	}

	public void setVolumePulverizador(BigDecimal volumePulverizador) {
		this.volumePulverizador = volumePulverizador;
	}

	public BigDecimal getVazaoHa() {
		return vazaoHa;
	}

	public void setVazaoHa(BigDecimal vazaoHa) {
		this.vazaoHa = vazaoHa;
	}

	/**
	 * @return the totalHaArea
	 */
	public BigDecimal getTotalHaArea() {
		return totalHaArea;
	}

	/**
	 * @param totalHaArea the totalHaArea to set
	 */
	public void setTotalHaArea(BigDecimal totalHaArea) {
		this.totalHaArea = totalHaArea;
	}

	/**
	 * @return the projetoPlantioVar
	 */
	public ProjetoPlantioAreaEntity getProjetoPlantioVar() {
		return projetoPlantioVar;
	}

	/**
	 * @param projetoPlantioVar the projetoPlantioVar to set
	 */
	public void setProjetoPlantioVar(ProjetoPlantioAreaEntity projetoPlantioVar) {
		this.projetoPlantioVar = projetoPlantioVar;
	}
		
}
