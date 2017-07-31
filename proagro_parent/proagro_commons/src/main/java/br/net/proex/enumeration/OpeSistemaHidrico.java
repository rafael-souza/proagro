package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum OpeSistemaHidrico {
    
	IRR("{opeSistemaHidrico.IRR}"),
	SEQ("{opeSistemaHidrico.SEQ}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private OpeSistemaHidrico(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
