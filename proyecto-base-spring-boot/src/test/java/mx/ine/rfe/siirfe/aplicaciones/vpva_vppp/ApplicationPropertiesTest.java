/**
 * ApplicationPropertiesTest.java
 * Fecha de creación: 26 ene. 2023, 23:44:16
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

package mx.ine.rfe.siirfe.aplicaciones.vpva_vppp;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Julio Cesar Betanzos Rivera (julio.betanzos@ine.mx)
 * @version 1.0
 * @since SIIRFE 6.5
 */
//@SpringBootTest
//@ActiveProfiles("test")
class ApplicationPropertiesTest {

	 //@Value("${hi}")
	  private String sayHi;
	 
	// @Test
	  void test(){
	    assertThat(sayHi).isEqualTo("hi");
	  }
}
