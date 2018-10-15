package io.swagger.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Negocio
 */
@Validated
@Entity
@Table(name = "negocio")
public class Negocio extends ResourceSupport {

	@JsonProperty("idInmueble")
	@ManyToOne
    @JoinColumn(name = "INMUEBLEID")
	private Inmueble idInmueble;

	@JsonProperty("idNegocio")
	@Column(name = "ID")
	@Id
	private String idNegocio;

	@JsonProperty("tipoNegocio")
	@Column(name = "tiponegocio")
	private String tipoNegocio;

	@JsonProperty("valor")
	@Column(name = "valor")
	private Integer valor;

	public Negocio() {
		super();
	}

	public Negocio(String idNegocio, Inmueble idInmueble, String tipoNegocio, Integer valor) {
		super();
		this.idNegocio = idNegocio;
		this.idInmueble = idInmueble;
		this.tipoNegocio = tipoNegocio;
		this.valor = valor;
	}

	public Negocio idInmueble(Inmueble idInmueble) {
		this.idInmueble = idInmueble;
		return this;
	}

	/**
	 * Get idInmueble
	 * 
	 * @return idInmueble
	 **/
	@ApiModelProperty(example = "apt123", required = true, value = "")
	@NotNull

	public Inmueble getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(Inmueble idInmueble) {
		this.idInmueble = idInmueble;
	}

	public Negocio tipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
		return this;
	}

	/**
	 * Get tipoNegocio
	 * 
	 * @return tipoNegocio
	 **/
	@ApiModelProperty(example = "compra", required = true, value = "")
	@NotNull

	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	public Negocio valor(Integer valor) {
		this.valor = valor;
		return this;
	}

	/**
	 * Get valor
	 * 
	 * @return valor
	 **/
	@ApiModelProperty(example = "2000", required = true, value = "")
	@NotNull

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	/**
	 * Get idNegocio
	 * 
	 * @return idNegocio
	 **/
	@ApiModelProperty(example = "rf222", required = true, value = "")
	@NotNull
	public String getIdNegocio() {
		return idNegocio;
	}

	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Negocio negocio = (Negocio) o;
		return Objects.equals(this.idInmueble, negocio.idInmueble)
				&& Objects.equals(this.tipoNegocio, negocio.tipoNegocio) && Objects.equals(this.valor, negocio.valor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idInmueble, tipoNegocio, valor);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Negocio {\n");
		sb.append("    idNegocio: ").append(toIndentedString(idNegocio)).append("\n");
		sb.append("    idInmueble: ").append(toIndentedString(idInmueble)).append("\n");
		sb.append("    tipoNegocio: ").append(toIndentedString(tipoNegocio)).append("\n");
		sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
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
