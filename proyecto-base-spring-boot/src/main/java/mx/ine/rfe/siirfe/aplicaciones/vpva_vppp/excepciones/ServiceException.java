/**
 * ServiceException.java
 * Fecha de creación: 2 feb. 2023, 14:23:17
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
 * Clase para el manejo de excepciones ya que se muestra hallazgo al usar las genericas 
 * @author Julio Cesar Betanzos Rivera (julio.betanzos@ine.mx)
 * @version 1.0
 * @since SIIRFE 6.5
 */

@SuppressWarnings("serial")
public class ServiceException extends Exception{
	
	private Integer errorCode;
	private String strErrorCode;

	public ServiceException() {
		super();
	}
	
	public ServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public ServiceException(String message, Throwable cause, ErrorCodes errorCode) {
		 super(message, cause);
	     this.errorCode = errorCode.getCode();
	}
	
	public ServiceException(String message, ErrorCodes errorCode) {
		 super(message);
	     this.strErrorCode = errorCode.getDescription();
	}
	
	public Integer getErrorCode() {
        return errorCode;
    }
	
	public String  getStrErrorCode() {
		return strErrorCode;
	}
	
	
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
