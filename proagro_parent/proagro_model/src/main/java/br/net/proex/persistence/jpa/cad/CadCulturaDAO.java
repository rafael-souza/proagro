package br.net.proex.persistence.jpa.cad;

import br.net.proex.persistence.jpa.AppJpaDAO;
import br.net.proex.entity.cad.CadCulturaEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import br.net.proex.enumeration.TipoCultura;

import java.util.List;

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

@PlcAggregationDAOIoC(CadCulturaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class CadCulturaDAO extends AppJpaDAO  {

	@PlcQuery("querySel2")
	public native List<CadCulturaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="nome like :nome || '%' ") String nome,
			@PlcQueryParameter(name="tipo", expression="tipo = :tipo") TipoCultura tipo
	);

	@PlcQuery("querySel2")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="nome like :nome || '%' ") String nome,
			@PlcQueryParameter(name="tipo", expression="tipo = :tipo") TipoCultura tipo
	);
	
}
