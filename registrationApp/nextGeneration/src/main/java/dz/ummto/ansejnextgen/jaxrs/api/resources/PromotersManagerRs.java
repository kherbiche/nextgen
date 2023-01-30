/*
 * Copyright (C) 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api.resources;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dz.ummto.ansejNextGen.jpa.dao.DaoFactory;
import dz.ummto.ansejNextGen.jpa.entities.Promoter;

/**
 * The <code>PromotersManagerRs</code> class represents the JaxRs Resource that
 * does <strong>The promoter manager processes</strong>.
 * <p>
 * <strong>The promoter registration process</strong> include multiple task:
 * list all promoters, update, delete the promoter and his address.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@RequestScoped
@Path("/rest")
public class PromotersManagerRs {

	private static final Log logger = LogFactory.getLog(PromotersManagerRs.class);

	@Path("/allpromoters")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@RolesAllowed(value = { "ROLE_COUNSELOR" })
	@PermitAll
	public Response getAllPromotersProcess() {

		logger.info("--- URI: /rest/allpromoters");
		logger.info("-- getAllPromotersProcess() threadName: " + Thread.currentThread().getName() + " threadId: "
				+ Thread.currentThread().getId());
		
		//IDao<PromoterId, Promoter> pDao = DaoFactory.getPromoterDao();
		return Response.ok(new GenericEntity<List<Promoter>>(DaoFactory.getPromoterDao().findAll()) {}).build();
		//return Response.ok(pDao.findAll()).build();
	}

}
