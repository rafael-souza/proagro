package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoEtapaProjetoPlantio {
    
	DESS("{codEtapaProjetoPlantio.01}"),
	ESPP("{codEtapaProjetoPlantio.02}"),
	PRFS("{codEtapaProjetoPlantio.03}"),
	PRFF("{codEtapaProjetoPlantio.04}"),
	TRAS("{codEtapaProjetoPlantio.05}"),
	ADBP("{codEtapaProjetoPlantio.06}"),
	ADBC("{codEtapaProjetoPlantio.07}"),
	CRTE("{codEtapaProjetoPlantio.08}"),
	PFV3("{codEtapaProjetoPlantio.09}"),
	SFR1("{codEtapaProjetoPlantio.10}"),
	TFR5("{codEtapaProjetoPlantio.11}");	
		
	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoEtapaProjetoPlantio(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
