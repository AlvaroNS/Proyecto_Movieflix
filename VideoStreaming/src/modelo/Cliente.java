package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;


/** Clase donde se recogen los atributos, Getter y Setter de Cliente, introducidos en la base de datos */
public class Cliente {
	
	private int idCliente;
	private String nombreCliente;
	private LocalDate fechaNacimiento;
	private String fechaR;
	private String ciudad;
	private String tipoAcceso;
	
	public String getFechaR() {
		return fechaR;
	}

	public void setFechaR(String fechaR) {
		this.fechaR = fechaR;
	}

	public Cliente() {}
	
	public Cliente (int idCliente, String nombreCliente, LocalDate fechaNacimiento, String ciudad, String tipoAcceso) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudad;
		this.tipoAcceso = tipoAcceso;
	}
	
	
	public Cliente (int idCliente, String nombreCliente, String ciudad, String tipoAcceso) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.ciudad = ciudad;
		this.tipoAcceso = tipoAcceso;
	}


	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/*public LocalDate fecha_nacimiento() {
        System.out.println("Introduzca Fecha de nacimiento: ");
        int dia = LecturaDatos.leerInt("Introduzca dia: ");
        int mes = LecturaDatos.leerInt("Introduzca mes: ");
        int year = LecturaDatos.leerInt("Introduzca año: ");

        return new LocalDate(new GregorianCalendar(year, mes - 1, dia).getTimeInMillis());
    }*/

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTipoAcceso() {
		return tipoAcceso;
	}

	public void setTipoAcceso(String tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}

	@Override
	public String toString() {
		return "Id Cliente: " + getIdCliente() + "\n"
                + "Nombre Ciente: " + getNombreCliente() + "\n"
                + "Fecha Nacimiento: " + new SimpleDateFormat("MM, dd, yyyy").format(getFechaNacimiento()) + "\n"
                + "Ciudad: " + getCiudad() + "\n"
                + "Tipo de Acceso: " + getTipoAcceso ();
	}
}
