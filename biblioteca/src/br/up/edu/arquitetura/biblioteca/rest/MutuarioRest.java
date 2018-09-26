package br.up.edu.arquitetura.biblioteca.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.up.edu.arquitetura.biblioteca.model.dominio.Mutuario;
import br.up.edu.arquitetura.biblioteca.model.negocio.MutuarioNegocio;

import java.net.URI;

@Path("api/mutuarios")
public class MutuarioRest {

	/*
	 * mn = Mutuario Negocio
	 */
	private MutuarioNegocio mn = new MutuarioNegocio();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Mutuario> find(@QueryParam("q") String query) throws Exception {
		mn.load();
		return mn.listarTodos();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Mutuario load(@PathParam("id") int id) throws Exception {
		Mutuario result = mn.findId(id);

		if (result == null) {
			throw new NotFoundException();
		}

		return result;
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response insert(Mutuario mutuario, @Context UriInfo uriInfo) throws Exception {

		String id = "" + mn.salvar(mutuario).getId();
		URI location = uriInfo.getRequestUriBuilder().path(id).build();

		return Response.created(location).entity(id).build();
	}

	@PUT
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(@PathParam("id") int id, Mutuario mutuario) throws Exception {

		mutuario.setId(id);
		mn.salvar(mutuario);
	}

}
