/**
 * Usuario.java
 * Fecha de creación: 3 feb. 2023, 15:42:50
 *
 * Copyright (c) 2023 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */

package mx.ine.rfe.siirfe.aplicaciones.vpva_vppp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bean de prueba o ejemplo 
 * @author Julio Cesar Betanzos Rivera (julio.betanzos@ine.mx)
 * @version 1.0
 * @since SIIRFE 6.7
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -3478192628123244815L;

	@Id
	@Basic(optional = false)
	@Column(name = "USUARIO_ID")
	private Long usuarioId;
	@Column(name = "NOMBRE", nullable=false)
	private String nombre;
	@Column(name = "APELLIDO_PATERNO", nullable=false)
	private String apellidoPaterno;
	@Column(name = "APELLIDO_MATERNO", nullable=false)
	private String apellidoMaterno;
	@Column(name = "TELEFONO")
	private String telefono;
	
	public Usuario() {
		//NADA QUE HACER 
	}

	/**
	 * @return el atributo usuarioId
	 */
	
	public Long getUsuarioId() {
		return usuarioId;
	}

	/**
	 * @param usuarioId parametro usuarioId a actualizar
	 */
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * @return el atributo nombre
	 */
	
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre parametro nombre a actualizar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el atributo apellidoPaterno
	 */
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno parametro apellidoPaterno a actualizar
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return el atributo apellidoMaterno
	 */
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno parametro apellidoMaterno a actualizar
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return el atributo telefono
	 */
	
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono parametro telefono a actualizar
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		return Objects.hash(usuarioId);
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuarioId, other.usuarioId);
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + "]";
	}
	
	
	
}
