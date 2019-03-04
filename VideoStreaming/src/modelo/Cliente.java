package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	private int idCliente;
	private String nombreCliente;
	private Date fechaNacimiento;
	private int ciudad;
	private TipoAcceso tipoAcceso;
	
	public Cliente() {}
	
	public Cliente (int idCliente, String nombreCliente, Date fechaNacimiento, int ciudad, TipoAcceso tipoAcceso) {
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getCiudad() {
		return ciudad;
	}

	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}

	public TipoAcceso getTipoAcceso() {
		return tipoAcceso;
	}

	public void setTipoAcceso(TipoAcceso tipoAcceso) {
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
