package br.net.proex.persistence.jpa.cad;

import br.net.proex.persistence.jpa.AppJpaDAO;
import br.net.proex.entity.cad.CadCidadeEntity;
import br.net.proex.entity.cad.CadClienteEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;

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

@PlcAggregationDAOIoC(CadClienteEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class CadClienteDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<CadClienteEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="nome like :nome || '%' ") String nome,
			@PlcQueryParameter(name="endereco_logradouro", expression="obj.endereco.logradouro like :endereco_logradouro || '%' ") String endereco_logradouro,
			@PlcQueryParameter(name="endereco_cidade", expression="obj1 = :endereco_cidade") CadCidadeEntity endereco_cidade
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="nome like :nome || '%' ") String nome,
			@PlcQueryParameter(name="endereco_logradouro", expression="obj.endereco.logradouro like :endereco_logradouro || '%' ") String endereco_logradouro,
			@PlcQueryParameter(name="endereco_cidade", expression="obj1 = :endereco_cidade") CadCidadeEntity endereco_cidade
	);
	
}
