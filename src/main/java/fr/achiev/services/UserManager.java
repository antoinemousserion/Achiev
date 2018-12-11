package fr.achiev.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import fr.achiev.aut.CheckUser;
import fr.achiev.bean.User;
import fr.achiev.dal.GenericDao;
import fr.achiev.dal.GenericDaoImpl;

@Path("/users")
public class UserManager {
	private GenericDao<User, Integer> daoInt = new GenericDaoImpl<>();
	private GenericDao<User, String> daoStr = new GenericDaoImpl<>();
	@Context
	private HttpServletRequest httpServletRequest;

	@GET
	public List<User> getUsers() {
		return daoInt.findAll(User.class);
	}

	@Path("/userSession")
	@GET
	public User getUserById() {
		HttpSession session = httpServletRequest.getSession();
		User res = (User) session.getAttribute("User");
		return res;

	}

	@Path("/signin")
	@POST
	public Response addUser(User u) {
		Response res = null;
		List<String> errs = CheckUser.check(u);
		try {
			
			if (!errs.isEmpty()) {
				return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
			}

			User isPresent = daoStr.findByAttr(User.class, "BattleTag", u.getBattleTag());

			if (isPresent != null) {
				errs.add("This battleTag already exists !");
				res = Response.status(Response.Status.BAD_REQUEST).entity(errs).build();

			} else {

				daoInt.add(u);
				res = Response.ok().build();
			}

		} catch (Exception e) {
			errs.add(e.getMessage());
			res = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errs).build();
		}

		return res;
	}

	@Path("/connexion")
	@POST
	public Response connexion(User u) {
		List<String> errs = new ArrayList<>();

		User user = daoStr.findByAttr(User.class, "BattleTag", u.getBattleTag());

		if (user == null) {
			errs.add("User inconnu");
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		// TODO encrypt
		if (user.getPassword().trim().equals(u.getPassword().trim())) {
			// mise en sessions
			HttpSession session = httpServletRequest.getSession();

			session.setAttribute("User", user);

			return Response.ok().build();
		}
		errs.add("Mot de passe incorrect");
		return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();

	}

	@Path("/modification")
	@PUT
	public Response updateUser(User u) {
		HttpSession session = httpServletRequest.getSession();
		User user = (User) session.getAttribute("User");
		List<String> errs = CheckUser.check(u);
		if (!errs.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		// TODO encrypt
		user.setPassword(u.getPassword());
		user.setBattleTag(u.getBattleTag());
		user.setEvent(u.getEvent());
		user.setUsername(u.getUsername());

		try {
			daoInt.update(user);
		} catch (Exception e) {
			errs.add("Erreur serveur");
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		return Response.ok().build();
	}

	@Path("/desinscription")
	@DELETE
	public Response deleteUser() {
		HttpSession session = httpServletRequest.getSession();
		User user = (User) session.getAttribute("User");
		List<String> errs = new ArrayList<>();

		session.setAttribute("User", null);

		try {
			daoInt.delete(user);
		} catch (Exception e) {
			errs.add("Erreur serveur");
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		return Response.ok().build();
	}

	@Path("/deconnexion")
	@POST
	public void deconnexion() {
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("User", null);
	}

}
