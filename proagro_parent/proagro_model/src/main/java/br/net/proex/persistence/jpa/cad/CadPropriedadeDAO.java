package br.net.proex.persistence.jpa.cad;

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

@PlcAggregationDAOIoC(CadPropriedadeEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class CadPropriedadeDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<CadPropriedadeEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like :nome || '%' ") String nome,
			@PlcQueryParameter(name="endereco_logradouro", expression="obj.endereco.logradouro like :endereco_logradouro || '%' ") String endereco_logradouro,
			@PlcQueryParameter(name="endereco_cidade", expression="obj1 = :endereco_cidade") CadCidadeEntity endereco_cidade
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like :nome || '%' ") String nome,
			@PlcQueryParameter(name="endereco_logradouro", expression="obj.endereco.logradouro like :endereco_logradouro || '%' ") String endereco_logradouro,
			@PlcQueryParameter(name="endereco_cidade", expression="obj1 = :endereco_cidade") CadCidadeEntity endereco_cidade
	);

	/**
	 * 
	 * @param context
	 * @param idArea
	 * @return
	 */
	public ProjetoPlantioAreaEntity buscaProjetoPlantioArea(PlcBaseContextVO context, Long idArea) {
		EntityManager em = getEntityManager(context);
		Query query = em.createNamedQuery("ProjetoPlantioAreaEntity.buscaProjetoPlantioArea");
		query.setParameter("idArea", idArea);		
		try {
			return (ProjetoPlantioAreaEntity)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
}
