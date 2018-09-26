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

import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.model.negocio.LivroNegocio;

import java.net.URI;

@Path("api/livros")
public class LivroRest {

	/*
	 * bc = business controller
	 */
	private LivroNegocio bc = new LivroNegocio();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Livro> find(@QueryParam("q") String query) throws Exception {
		if (bc.listarTodos().size() == 0) {
			bc.load();
			
		}
		return bc.listarTodos();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Livro load(@PathParam("id") int id) throws Exception {

		Livro result = bc.findId(id);

		if (result == null) {
			throw new NotFoundException();
		}

		return result;
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response insert(Livro livro, @Context UriInfo uriInfo) throws Exception {

		String id = "" + bc.salvar(livro).getId();
		URI location = uriInfo.getRequestUriBuilder().path(id).build();

		return Response.created(location).entity(id).build();
	}

	@PUT
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(@PathParam("id") int id, Livro livro) throws Exception {

		livro.setId(id);
		bc.salvar(livro);
	}

}
