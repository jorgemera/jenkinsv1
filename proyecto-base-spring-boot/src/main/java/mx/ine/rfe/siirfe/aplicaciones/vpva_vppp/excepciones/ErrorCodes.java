/**
 * ErrorCodes.java
 * Fecha de creación: 2 feb. 2023, 14:22:07
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

package mx.ine.rfe.siirfe.aplicaciones.vpva_vppp.excepciones;

/**
 * Codigos de error para las excepciones
 * @author Julio Cesar Betanzos Rivera (julio.betanzos@ine.mx)
 * @version 1.0
 * @since SIIRFE 6.7
 */

public enum ErrorCodes {

	INVALID_PARAMETER(1, "PARAMETRO INVALIDO"), OPERACION_NO_PERMITIDA(2, "OPERACION NO PERMITIDA");

	private int code;
	private String description;

	ErrorCodes(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
