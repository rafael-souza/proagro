package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum CadTipoContato {
    
	TEL("{cadTipoContato.TEL}"),
	CEL("{cadTipoContato.CEL}"),
	EMA("{cadTipoContato.EMA}"),
	WTH("{cadTipoContato.WTH}"),
	FAX("{cadTipoContato.FAX}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private CadTipoContato(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
