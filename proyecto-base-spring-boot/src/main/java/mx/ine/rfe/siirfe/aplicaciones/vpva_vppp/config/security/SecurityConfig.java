/**
 * SecurityConfig.java
 * Fecha de creación: 19 ene. 2023, 17:35:54
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;


@Configuration
@EnableGlobalMethodSecurity(
	    securedEnabled = true,
	    prePostEnabled = true)
public class SecurityConfig  {
	
	@Value("${ldap-user-dn-patterns}")
	private String ldapUserDnPatterns;
		
	@Value("${ldap-url}")
	private String ldapUrl;
	
	@Value("${base-domain}")
	private String baseDomain;
	
	@Value("${ldap-user}")
	private String ldapUser;
	
	@Value("${ldap-password}")
	private String permisoEnvio;
	
	@Value("${ldap-group-search-base}")
	private String ldapGroupSearchBase;
	
	@Value("${ldap-group-role}")
	private String ldapGruopRole;
	
	@Value("${ldap-group-search-filter}")
	private String ldapGroupSearchFilter;
		
	@Value("${ldap-role-prefix}")
	private String ldapRolePrefix;
	
	@Value("${rol-ddvc-mre}")
	private String rolDDVC;
	
//	@Value("${spring.websecurity.debug:false}")
//    boolean webSecurityDebug;
	
	@Autowired
	private UserDetailsContextMapperImpl userContextMapperImpl;

	@Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception { 
		
        auth
        .ldapAuthentication()
        .userDnPatterns (ldapUserDnPatterns)
        .contextSource ()
        .url (ldapUrl.concat("/").concat(baseDomain))
        .managerDn (ldapUser)
            .managerPassword(permisoEnvio)
            .and()
        .groupSearchBase(ldapGroupSearchBase)
        .userDetailsContextMapper(userContextMapperImpl)
        .groupRoleAttribute(ldapGruopRole)
        .groupSearchFilter(ldapGroupSearchFilter)
        .rolePrefix(ldapRolePrefix);

    }
		
	@Bean
	protected SecurityFilterChain filterChain (HttpSecurity http) throws Exception  {
		
		http.authorizeRequests()
		.antMatchers(
				"/imagenes/**", 
				"/css/**", 
				"/js/**", 
				"/temas/**").permitAll()
		.antMatchers(
//				"/",
//				"/index",
				"/login")
			.permitAll()
//		.antMatchers("/administracion**").authenticated()
//		.access("hasRole('" + ldapRolePrefix + rolAdministrador +    "')")
//		.hasAnyRole(ldapRolePrefix.concat(rolDDVC))  ROLE_rolAdministrador
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/index")
		.and().logout().permitAll()
		.and().logout().deleteCookies("JSESSIONID")
		.and()
		.sessionManagement()
			.invalidSessionUrl("/logout")
//		Session Fixation Protection
        	.sessionFixation().migrateSession()
        	.maximumSessions(1)
        	.expiredUrl("/login?invalid-session=true");
		
		http.headers().xssProtection().xssProtectionEnabled(true).and().contentSecurityPolicy("default-src 'self';");
		
		return http.build();
	}
	
	
	
//	Enabling Loggin spring security whit properties file
//	@Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.debug(webSecurityDebug);
//    }
	
//	enabling the concurrent session-control support
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}
	
	
}
