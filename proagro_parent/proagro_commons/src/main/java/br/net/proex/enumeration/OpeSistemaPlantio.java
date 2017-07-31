package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum OpeSistemaPlantio {
    
	DIR("{opeSistemaPlantio.DIR}"),
	CON("{opeSistemaPlantio.CON}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private OpeSistemaPlantio(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
