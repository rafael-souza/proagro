package br.net.proex.persistence.jpa.ope;

import br.net.proex.persistence.jpa.AppJpaDAO;
import br.net.proex.entity.ope.EtapasProjetoPlantioAreaEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;

import java.util.List;

import javax.persistence.EntityManager;

import com.powerlogic.jcompany.persistence.jpa.PlcQuery;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryLineAmount;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryOrderBy;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryFirstLine;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationDAOIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryService;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(EtapasProjetoPlantioAreaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class EtapasProjetoPlantioAreaDAO extends AppJpaDAO  {

	@Override
	public void update(PlcBaseContextVO context, Object entity) {
		EtapasProjetoPlantioAreaEntity etapas = (EtapasProjetoPlantioAreaEntity) entity;
		EntityManager em = getEntityManager(context);
		//em.merge(etapas.getProjetoPlantioArea());
		super.update(context, entity);
	}
}
