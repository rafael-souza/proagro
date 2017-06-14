package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoCultura {
    
	HIB("{tipoCultura.HIB}"),
	VAR("{tipoCultura.VAR}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoCultura(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
