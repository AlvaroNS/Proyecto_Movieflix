package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
<<<<<<< HEAD:VideoStreaming/src/modelo/Cliente.java
import java.util.Date;
=======
>>>>>>> b13a4f3815ac785c2ba7d5e77dc872c3cbcefa4e:VideoStreaming_FINAL/src/modelo/Cliente.java

public class Cliente {
	
	private int idCliente;
	private String nombreCliente;
	private LocalDate fechaNacimiento;
	private String ciudad;
	private String tipoAcceso;
	
	public Cliente() {}
	
	public Cliente (int idCliente, String nombreCliente, LocalDate fechaNacimiento, String ciudad, String tipoAcceso) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.fechaNacimiento = fechaNacimiento;
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

	public void setNombrecliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

<<<<<<< HEAD:VideoStreaming/src/modelo/Cliente.java
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
=======
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
>>>>>>> b13a4f3815ac785c2ba7d5e77dc872c3cbcefa4e:VideoStreaming_FINAL/src/modelo/Cliente.java

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
