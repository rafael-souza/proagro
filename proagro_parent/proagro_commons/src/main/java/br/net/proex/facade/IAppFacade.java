package br.net.proex.facade;

import java.util.List;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.facade.IPlcFacade;

import br.net.proex.entity.cad.CadCulturaEntity;
import br.net.proex.entity.cad.CadPropriedadeAreaEntity;
import br.net.proex.entity.ope.ProjetoPlantioAreaEntity;
import br.net.proex.entity.seg.SegMenuEntity;
import br.net.proex.entity.seg.SegPerfilEntity;
import br.net.proex.entity.seg.SegUsuarioEntity;

public interface IAppFacade extends IPlcFacade{
	
	SegUsuarioEntity findUsuarioByLogin(PlcBaseContextVO context, String login);
	
	SegPerfilEntity findByPerfil(PlcBaseContextVO context, SegPerfilEntity perfil);	
	
	List<SegMenuEntity> findMenus(PlcBaseContextVO context);
	
	SegUsuarioEntity recuperaUsuario(PlcBaseContextVO context, SegUsuarioEntity usuario);

	String buscarClientePropriedade(PlcBaseContextVO context, Long id);

	CadPropriedadeAreaEntity findAreaById(PlcBaseContextVO context, String idArea);

	ProjetoPlantioAreaEntity buscaProjetoPlantioArea(PlcBaseContextVO context, Long idArea);

	CadCulturaEntity findCulturaById(PlcBaseContextVO context, Long idCultura);

	ProjetoPlantioAreaEntity buscaProjetoPlantioById(PlcBaseContextVO context, Long idProjetoPlantio);
	
}
