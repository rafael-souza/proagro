/* ************************* META-DADOS GLOBAIS DA APLICAÇÃO ******************************
  ********************** Configurações padrão para toda a aplicação *************************
  ************ Obs: configurações corporativas devem estar no nível anterior,****************
  ************              preferencialmente na camada Bridge               ****************
  *******************************************************************************************/


@PlcConfigApplication(
	definition=@PlcConfigApplicationDefinition(name="proagro",acronym="proagro",version=1,release=0),
	classesDiscreteDomain={br.net.proex.enumeration.OpeSistemaPlantio.class,br.net.proex.enumeration.OpeSistemaHidrico.class,br.net.proex.enumeration.CadMeses.class,br.net.proex.enumeration.TipoEtapaProjetoPlantio.class,br.net.proex.enumeration.TipoCultura.class,
			br.net.proex.enumeration.CadTipoContato.class,
			br.net.proex.enumeration.CadUf.class,
			br.net.proex.enumeration.SegAcaoRealizada.class,
			br.net.proex.enumeration.SegTipoAcesso.class,
			br.net.proex.enumeration.SegVisibilidadeCampo.class,
			br.net.proex.enumeration.SegAcao.class
	},
	classesLookup={br.net.proex.entity.cad.CadProdutoEntity.class,
			br.net.proex.entity.cad.CadEtapaProjetoPlantioEntity.class,
			br.net.proex.entity.cad.CadCulturaEntity.class}
)


package com.powerlogic.jcompany.config.app;

import com.powerlogic.jcompany.config.application.PlcConfigApplication;
import com.powerlogic.jcompany.config.application.PlcConfigApplicationDefinition;
