package io.swagger.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Inmueble
 */
@Validated

public class Inmueble extends ResourceSupport {
	@JsonProperty("idTipoInmueble")
	private String idTipoInmueble = null;

	@JsonProperty("idInmueble")
	private String idInmueble = null;

	@JsonProperty("nombre")
	private String nombre = null;

	@JsonProperty("direccion")
	private String direccion = null;

	@JsonProperty("region")
	private String region = null;

	@JsonProperty("precioMinimo")
	private Integer precioMinimo = null;

	@JsonProperty("precioMaximo")
	private Integer precioMaximo = null;

	@JsonProperty("telefono")
	private String telefono = null;
	
	public Inmueble() {
		super();
	}

	public Inmueble(String idTipoInmueble, String idInmueble, String nombre, String direccion, String region,
			Integer precioMinimo, Integer precioMaximo, String telefono) {
		super();
		this.idTipoInmueble = idTipoInmueble;
		this.idInmueble = idInmueble;
		this.nombre = nombre;
		this.direccion = direccion;
		this.region = region;
		this.precioMinimo = precioMinimo;
		this.precioMaximo = precioMaximo;
		this.telefono = telefono;
	}

	public Inmueble idTipoInmueble(String idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
		return this;
	}

	/**
	 * Get idTipoInmueble
	 * 
	 * @return idTipoInmueble
	 **/
	@ApiModelProperty(example = "apt1234", required = true, value = "")
	@NotNull

	public String getIdTipoInmueble() {
		return idTipoInmueble;
	}

	public void setIdTipoInmueble(String idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
	}

	public Inmueble idInmueble(String idInmueble) {
		this.idInmueble = idInmueble;
		return this;
	}

	/**
	 * Get idInmueble
	 * 
	 * @return idInmueble
	 **/
	@ApiModelProperty(example = "ref123", required = true, value = "")
	@NotNull

	public String getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(String idInmueble) {
		this.idInmueble = idInmueble;
	}

	public Inmueble nombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	/**
	 * Get nombre
	 * 
	 * @return nombre
	 **/
	@ApiModelProperty(example = "Villa Rreal", required = true, value = "")
	@NotNull

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Inmueble direccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	/**
	 * Get direccion
	 * 
	 * @return direccion
	 **/
	@ApiModelProperty(example = "Cr 25", required = true, value = "")
	@NotNull

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Inmueble region(String region) {
		this.region = region;
		return this;
	}

	/**
	 * Get region
	 * 
	 * @return region
	 **/
	@ApiModelProperty(example = "Antioquia", required = true, value = "")
	@NotNull

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Inmueble precioMinimo(Integer precioMinimo) {
		this.precioMinimo = precioMinimo;
		return this;
	}

	/**
	 * Get precioMinimo
	 * 
	 * @return precioMinimo
	 **/
	@ApiModelProperty(example = "1000", required = true, value = "")
	@NotNull

	public Integer getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(Integer precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public Inmueble precioMaximo(Integer precioMaximo) {
		this.precioMaximo = precioMaximo;
		return this;
	}

	/**
	 * Get precioMaximo
	 * 
	 * @return precioMaximo
	 **/
	@ApiModelProperty(example = "2000", required = true, value = "")
	@NotNull

	public Integer getPrecioMaximo() {
		return precioMaximo;
	}

	public void setPrecioMaximo(Integer precioMaximo) {
		this.precioMaximo = precioMaximo;
	}

	public Inmueble telefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	/**
	 * Get telefono
	 * 
	 * @return telefono
	 **/
	@ApiModelProperty(example = "1234", required = true, value = "")
	@NotNull

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Inmueble inmueble = (Inmueble) o;
		return Objects.equals(this.idTipoInmueble, inmueble.idTipoInmueble)
				&& Objects.equals(this.idInmueble, inmueble.idInmueble) && Objects.equals(this.nombre, inmueble.nombre)
				&& Objects.equals(this.direccion, inmueble.direccion) && Objects.equals(this.region, inmueble.region)
				&& Objects.equals(this.precioMinimo, inmueble.precioMinimo)
				&& Objects.equals(this.precioMaximo, inmueble.precioMaximo)
				&& Objects.equals(this.telefono, inmueble.telefono);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoInmueble, idInmueble, nombre, direccion, region, precioMinimo, precioMaximo,
				telefono);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Inmueble {\n");

		sb.append("    idTipoInmueble: ").append(toIndentedString(idTipoInmueble)).append("\n");
		sb.append("    idInmueble: ").append(toIndentedString(idInmueble)).append("\n");
		sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
		sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
		sb.append("    region: ").append(toIndentedString(region)).append("\n");
		sb.append("    precioMinimo: ").append(toIndentedString(precioMinimo)).append("\n");
		sb.append("    precioMaximo: ").append(toIndentedString(precioMaximo)).append("\n");
		sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
