package br.net.proex.facade;

import java.util.List;

import javax.inject.Inject;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcFacade;
import com.powerlogic.jcompany.facade.PlcFacadeImpl;

import br.net.proex.entity.cad.CadCulturaEntity;
import br.net.proex.entity.cad.CadPropriedadeAreaEntity;
import br.net.proex.entity.cad.CadPropriedadeClienteEntity;
import br.net.proex.entity.cad.CadPropriedadeEntity;
import br.net.proex.entity.ope.ProjetoPlantioAreaEntity;
import br.net.proex.entity.seg.SegMenuEntity;
import br.net.proex.entity.seg.SegPerfilEntity;
import br.net.proex.entity.seg.SegUsuarioEntity;
import br.net.proex.persistence.jpa.cad.CadCulturaDAO;
import br.net.proex.persistence.jpa.cad.CadPropriedadeDAO;
import br.net.proex.persistence.jpa.ope.ProjetoPlantioAreaDAO;
import br.net.proex.persistence.jpa.seg.SegMenuDAO;
import br.net.proex.persistence.jpa.seg.SegPerfilDAO;
import br.net.proex.persistence.jpa.seg.SegUsuarioDAO;

@QPlcDefault
@SPlcFacade
public class AppFacadeImpl extends PlcFacadeImpl implements IAppFacade{

	@Inject 
	private SegUsuarioDAO usuarioDAO;

	@Inject 
	private SegPerfilDAO perfilDAO;
	
	@Inject 
	private SegMenuDAO menuDAO;
	
	@Inject 
	private CadPropriedadeDAO propriedadeDAO;			
	
	@Inject
	private CadCulturaDAO culturaDAO;
	
	@Inject
	private ProjetoPlantioAreaDAO projetoPlantioAreaDAO;

	@Override
	public SegUsuarioEntity findUsuarioByLogin(PlcBaseContextVO context, String login) {
		return usuarioDAO.findByLogin(context, login);
	}

	@Override
	public SegPerfilEntity findByPerfil(PlcBaseContextVO context, SegPerfilEntity perfil) {		
		return (SegPerfilEntity) perfilDAO.findById(context,	SegPerfilEntity.class, perfil.getId());

	}

	@Override
	public List<SegMenuEntity> findMenus(PlcBaseContextVO context) {
		return menuDAO.findList(context, new SegMenuEntity(), "", 0, 0);
	}

	@Override
	public SegUsuarioEntity recuperaUsuario(PlcBaseContextVO context, SegUsuarioEntity usuario) { 
		return (SegUsuarioEntity)usuarioDAO.findById(context, SegUsuarioEntity.class, usuario.getId());
	}

	/**
	 * Busca os clientes da propriedade
	 */
	@Override
	public String buscarClientePropriedade(PlcBaseContextVO context, Long id) {
		CadPropriedadeClienteEntity propriedadeClienteFiltro = new CadPropriedadeClienteEntity();
		CadPropriedadeEntity propriedade = new CadPropriedadeEntity();
		propriedade.setId(id);
		
		propriedadeClienteFiltro.setPropriedade(propriedade);
		
		List<CadPropriedadeClienteEntity> propriedadeClienteLista = 
				(List<CadPropriedadeClienteEntity>) this.findList(context, propriedadeClienteFiltro, "", 0, 0);
		StringBuilder retorno = new StringBuilder();
		if (null != propriedadeClienteLista && propriedadeClienteLista.size() > 0){
			for (CadPropriedadeClienteEntity propriedadeCliente : propriedadeClienteLista){
				if (retorno.length() == 0){
					retorno.append(propriedadeCliente.getCliente().getNome());
				} else {
					retorno.append(", " + propriedadeCliente.getCliente().getNome());
				}
			}			
		}		
		
		return retorno.toString();
	}

	/**
	 * 
	 */
	@Override
	public CadPropriedadeAreaEntity findAreaById(PlcBaseContextVO context, String idArea) {
		return (CadPropriedadeAreaEntity)propriedadeDAO.findById(context, CadPropriedadeAreaEntity.class, Long.valueOf(idArea));
	}

	/**
	 * 
	 */
	@Override
	public ProjetoPlantioAreaEntity buscaProjetoPlantioArea(PlcBaseContextVO context, Long idArea) {
		return propriedadeDAO.buscaProjetoPlantioArea(context, idArea);
	}

	@Override
	public CadCulturaEntity findCulturaById(PlcBaseContextVO context, Long idCultura) {		
		return (CadCulturaEntity)culturaDAO.findById(context, CadCulturaEntity.class, idCultura);
	}

	@Override
	public ProjetoPlantioAreaEntity buscaProjetoPlantioById(PlcBaseContextVO context, Long idProjetoPlantio) {
		return (ProjetoPlantioAreaEntity) projetoPlantioAreaDAO.findById(context, ProjetoPlantioAreaEntity.class, idProjetoPlantio);
	}
	
}
