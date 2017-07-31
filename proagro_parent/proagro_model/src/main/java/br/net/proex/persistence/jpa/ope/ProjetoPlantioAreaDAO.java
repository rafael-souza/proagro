package br.net.proex.persistence.jpa.ope;

import br.net.proex.persistence.jpa.AppJpaDAO;
import br.net.proex.entity.cad.CadPropriedadeEntity;
import br.net.proex.entity.ope.ProjetoPlantioAreaEntity;

import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import br.net.proex.entity.cad.CadCidadeEntity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

@PlcAggregationDAOIoC(ProjetoPlantioAreaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class ProjetoPlantioAreaDAO extends AppJpaDAO  {

}
