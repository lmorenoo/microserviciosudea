package io.swagger.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * TipoInmueble
 */
@Validated

public class TipoInmueble extends ResourceSupport {
	@JsonProperty("idTipoInmueble")
	private String idTipoInmueble = null;

	@JsonProperty("nombre")
	private String nombre = null;

	public TipoInmueble() {

	}

	public TipoInmueble(String idTipoInmueble, String nombre) {
		super();
		this.idTipoInmueble = idTipoInmueble;
		this.nombre = nombre;
	}

	public TipoInmueble idTipoInmueble(String idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
		return this;
	}

	/**
	 * Get idTipoInmueble
	 * 
	 * @return idTipoInmueble
	 **/
	@ApiModelProperty(example = "t123", required = true, value = "")
	@NotNull

	public String getIdTipoInmueble() {
		return idTipoInmueble;
	}

	public void setIdTipoInmueble(String idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
	}

	public TipoInmueble nombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	/**
	 * Get nombre
	 * 
	 * @return nombre
	 **/
	@ApiModelProperty(example = "Apartamento", required = true, value = "")
	@NotNull

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TipoInmueble tipoInmueble = (TipoInmueble) o;
		return Objects.equals(this.idTipoInmueble, tipoInmueble.idTipoInmueble)
				&& Objects.equals(this.nombre, tipoInmueble.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoInmueble, nombre);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TipoInmueble {\n");

		sb.append("    idTipoInmueble: ").append(toIndentedString(idTipoInmueble)).append("\n");
		sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
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
