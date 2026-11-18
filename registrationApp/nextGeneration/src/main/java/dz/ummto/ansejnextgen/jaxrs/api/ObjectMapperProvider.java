/*
 * Copyright 2008, 2026 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

/**
 * The <code>ObjectMapperProvider</code> class represents JAX-RS provider for
 * {@link JsonMapper}.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Provider
public class ObjectMapperProvider implements ContextResolver<JsonMapper> {

	private static final JsonMapper MAPPER = JsonMapper.builder()
			.findAndAddModules() // Détecte automatiquement les modules (JavaTime, etc.)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.enable(SerializationFeature.INDENT_OUTPUT)
			.build();

	@Override
	public JsonMapper getContext(Class<?> type) {
		return MAPPER;
	}

	// Méthode utilitaire pour un accès direct hors contexte JAX-RS
	public static JsonMapper getMapper() {
		return MAPPER;
	}
}
