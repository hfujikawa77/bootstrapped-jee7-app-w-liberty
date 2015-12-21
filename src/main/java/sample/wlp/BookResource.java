package sample.wlp;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

	@PersistenceContext(name = "jee7-app-pu")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@GET
	@Path("/")
	public List<BookEntity> findAll() {
		return em.createNamedQuery("BookEntity.findAll").getResultList();
	}

	@PUT
	@Path("/{title}/{author}")
	@Transactional
	public List<BookEntity> entry(@PathParam("title") String title,
			@PathParam("author") String author) {
		BookEntity book = new BookEntity();
		book.setTitle(title);
		book.setAuthor(author);
		em.persist(book);
		return findAll();
	}
}
