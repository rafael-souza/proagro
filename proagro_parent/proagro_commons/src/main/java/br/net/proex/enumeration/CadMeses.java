package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum CadMeses {
    
	JAN("{cadMeses.JAN}"),
	FEV("{cadMeses.FEV}"),
	MAR("{cadMeses.MAR}"),
	ABR("{cadMeses.ABR}"),
	MAI("{cadMeses.MAI}"),
	JUN("{cadMeses.JUN}"),
	JUL("{cadMeses.JUL}"),
	AGO("{cadMeses.AGO}"),
	SET("{cadMeses.SET}"),
	OUT("{cadMeses.OUT}"),
	NOV("{cadMeses.NOV}"),
	DEZ("{cadMeses.DEZ}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private CadMeses(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
