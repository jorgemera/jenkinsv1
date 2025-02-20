/**
 * UserDetailsContextMapperImpl.java
 * Fecha de creación: 31 ene. 2023, 19:01:27
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

package mx.ine.rfe.siirfe.aplicaciones.vpva_vppp.config.security;

import java.io.Serializable;
import java.util.Collection;

import javax.naming.directory.Attributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.stereotype.Component;

/**
 * Mapeo para conservar detalles del usuario ldap copia del comun usuario login
 * @author Julio Cesar Betanzos Rivera (julio.betanzos@ine.mx)
 * @version 1.0
 * @since SIIRFE 6.7
 */
@Component
public class UserDetailsContextMapperImpl  implements UserDetailsContextMapper, Serializable{
	
	 private static final Logger logger = LoggerFactory.getLogger( UserDetailsContextMapperImpl.class );
	    

	    private static final long serialVersionUID = -5907211462770124604L;

	    @Value("${ldap.usuario.nombre}")
	    private String ldapNombre;

	    @Value("${ldap.usuario.apellidoPaterno}")
	    private String ldapApellidoPaterno;

	    @Value("${ldap.usuario.apellidoMaterno}")
	    private String ldapApellidoMaterno;

	    @Value("${ldap.usuario.correoElectronico}")
	    private String ldapCorreoElectronico;

	    @Value("${ldap.usuario.nivel}")
	    private String ldapNivel;

	    @Value("${ldap.usuario.estado}")
	    private String ldapEstado;

	    @Value("${ldap.usuario.distrito}")
	    private String ldapDistrito;

	    @Value("${ldap.usuario.modulo}")
	    private String ldapModulo;

	    @Value("${ldap.usuario.circunscripcion}")
	    private String ldapCircunscripcion; 

	    @Value("${ldap.usuario.descripcion}")
	    private String ldapDrescripcion;
	    // Se pone este ya que no tengo en mi ldap el atributo UidNumber supongo que se llama asi 
	    // pero no estoy seguro mas adelante hay que consultar esta informacion
	    @Value("${ldap.usuario.id}")
	    private String ldapUidNumber;
	    
	    private UserDetailsImpl userDetails = null;

	    @Override
	    public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
	        Collection<? extends GrantedAuthority> authority) {
	        logger.debug("Authorities encontradas : {}",authority);
	        UserDetailsImpl userDetails =
	            new UserDetailsImpl(username, "", true, true, true, true, authority);

	        Attributes attributes = ctx.getAttributes();

	        String nombre = getValue(attributes, ldapNombre);
	        String apellidoPaterno = getValue(attributes, ldapApellidoPaterno);
	        String apellidoMaterno = getValue(attributes, ldapApellidoMaterno);
	        String nivel = getValue(attributes, ldapNivel);
	        String estado = getValue(attributes, ldapEstado);
	        String distrito = getValue(attributes, ldapDistrito);
	        String correoElectronico = getValue(attributes, ldapCorreoElectronico);
	        String modulo = getValue(attributes, ldapModulo);
	        String circunscripcion = getValue(attributes, ldapCircunscripcion);
	        String descripcion = getValue(attributes, ldapDrescripcion);
	        String token = getValue(attributes, "tokenKey");
	        String uidNumber = getValue(attributes, ldapUidNumber);
	        
	        userDetails.setNombre(nombre);
	        userDetails.setApellidoPaterno(apellidoPaterno);
	        userDetails.setApellidoMaterno(apellidoMaterno);
	        userDetails.setNivel(nivel);
	        userDetails.setEstado(estado);
	        userDetails.setDistrito(distrito);
	        userDetails.setCorreoElectronico(correoElectronico);
	        userDetails.setModulo(modulo);
	        userDetails.setCircunscripcion(circunscripcion);
	        userDetails.setDescripcion(descripcion);
	        userDetails.setTokenKey(token);
	        userDetails.setUidNumber(uidNumber);
	        
	        this.userDetails = userDetails;

	        return userDetails;
	    }
	    
	    private String getValue(Attributes attributes, String name) {
	        try {
	            return (String) attributes.get(name).get();
	        } catch (Exception e ) {
	            return " ";
	        } 
	    }

	    @Override
	    public void mapUserToContext(UserDetails arg0, DirContextAdapter arg1) {
	        // No se utiliza
	    }
	    
	    public UserDetails getUserDetails() {
			return this.userDetails;
		}

}
