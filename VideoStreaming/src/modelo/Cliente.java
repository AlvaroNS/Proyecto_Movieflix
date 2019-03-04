package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Cliente {
	
	private int idCliente;
	private String nombreCliente;
	private LocalDate fechaNacimiento;
	private String ciudad;
	private String tipoAcceso;
	
	p
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
