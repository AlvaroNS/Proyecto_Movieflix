package modelo;


/** Clase donde se recogen los atributos, Getter y Setter de Pelicula, introducidos en la base de datos */
public class Pelicula {
	
	private int idPelicula;
	private String nombrePelicula;
	private int anioEstreno;
	private String categoria;
	private int visualizacion;
	private int valoracion;
	
	public Pelicula () {}
	
	
	public Pelicula (int idPelicula, String nomPelicula, int anioEstreno, 
		String categoria) {
		
		this.idPelicula = idPelicula;
		nombrePelicula = nomPelicula;
		this.anioEstreno = anioEstreno;
		this.categoria = categoria;
	}
	
	
	public Pelicula (int idPelicula, String nomPelicula, int anioEstreno, 
		String categoria, int visualizacion, int valoracion) {
		
		this.idPelicula = idPelicula;
		nombrePelicula = nomPelicula;
		this.anioEstreno = anioEstreno;
		this.categoria = categoria;
		this.visualizacion = visualizacion;
		this.valoracion = valoracion;
		
	}


	public int getIdPelicula() {
		return idPelicula;
	}


	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}


	public String getNombrePelicula() {
		return nombrePelicula;
	}


	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}


	public int getAnioEstreno() {
		return anioEstreno;
	}


	public void setAnioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getVisualizacion() {
		return visualizacion;
	}


	public void setVisualizacion(int visualizacion) {
		this.visualizacion = visualizacion;
	}


	public int getValoracion() {
		return valoracion;
	}


	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	@Override
	public String toString() {
		return "Id Pelicula: " + getIdPelicula() + "\n"
                + "Nombre Pelicula: " + getNombrePelicula() + "\n"
                + "Año Estreno: " + getAnioEstreno() + "\n"
                + "Categoria: " + getCategoria() + "\n"
                + "Visualizacion: " + getVisualizacion() + "\n"
				+ "Valoracion: " + getValoracion() + "\n";
	}
	
}


