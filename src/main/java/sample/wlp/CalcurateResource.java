package sample.wlp;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@ApplicationScoped
@Path("/calc")
public class CalcurateResource {

	@GET
	@Path("/add/{1}/{2}")
	public int add(@PathParam("1") int f, @PathParam("2") int s) {
		return f + s;
	}

	@GET
	@Path("/sub/{1}/{2}")
	public int sub(@PathParam("1") int f, @PathParam("2") int s) {
		return f - s;
	}

	@GET
	@Path("/mul/{1}/{2}")
	public int mul(@PathParam("1") int f, @PathParam("2") int s) {
		return f * s;
	}

	@GET
	@Path("/div/{1}/{2}")
	public int div(@PathParam("1") int f, @PathParam("2") int s) {
		return f / s;
	}

	static class HelloWlpUser {
		public HelloWlpUser(String name, String greeting) {
			super();
			this.name = name;
			this.greeting = greeting;
		}

		String name;
		String greeting;

		public String getName() {
			return name;
		}

		public String getGreeting() {
			return greeting;
		}
	}
}
