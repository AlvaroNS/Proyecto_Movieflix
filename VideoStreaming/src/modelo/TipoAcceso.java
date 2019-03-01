package modelo;

// Enumerado que indica el tipo de acceso en el caso de 
// que se quiera modificar el acceso Premium de los clientes 

public enum TipoAcceso { 
	
	BASICO (1), EXTRA (2), PREMIUM (6);
	
	private final int numCatalogos;
	
	private TipoAcceso (int numCatalogos) {
		this.numCatalogos = numCatalogos;
	}

	public int getNumCatalogos() {
		return numCatalogos;
	}
}
