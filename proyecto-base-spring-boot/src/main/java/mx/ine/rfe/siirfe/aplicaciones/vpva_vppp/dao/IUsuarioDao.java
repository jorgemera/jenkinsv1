/**
 * IUsuarioDao.java
 * Fecha de creación: 3 feb. 2023, 15:45:34
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

package mx.ine.rfe.siirfe.aplicaciones.vpva_vppp.dao;

import org.springframework.data.repository.CrudRepository;

import mx.ine.rfe.siirfe.aplicaciones.vpva_vppp.model.Usuario;

/**
 * Bean de ejemplo
 * @author Julio Cesar Betanzos Rivera (julio.betanzos@ine.mx)
 * @version 1.0
 * @since SIIRFE 6.7
 */

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
