package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum CadUf {
    
	AC("{cadUf.AC}"),
	AL("{cadUf.AL}"),
	AP("{cadUf.AP}"),
	AM("{cadUf.AM}"),
	BA("{cadUf.BA}"),
	CE("{cadUf.CE}"),
	DF("{cadUf.DF}"),
	ES("{cadUf.ES}"),
	GO("{cadUf.GO}"),
	MA("{cadUf.MA}"),
	MS("{cadUf.MS}"),
	MG("{cadUf.MG}"),
	MT("{cadUf.MT}"),	
	PA("{cadUf.PA}"),
	PB("{cadUf.PB}"),
	PR("{cadUf.PR}"),
	PE("{cadUf.PE}"),
	PI("{cadUf.PI}"),
	RJ("{cadUf.RJ}"),
	RN("{cadUf.RN}"),
	RS("{cadUf.RS}"),
	RO("{cadUf.RO}"),
	RR("{cadUf.RR}"),
	SC("{cadUf.SC}"),
	SP("{cadUf.SP}"),
	SE("{cadUf.SE}"),
	TO("{cadUf.TO}"),
	EX("{cadUf.EX}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private CadUf(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
