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
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import fr.achiev.aut.CheckUser;
import fr.achiev.bean.UserAchiev;
import fr.achiev.dal.GenericDao;
import fr.achiev.dal.GenericDaoImpl;

@Path("/users")
public class UserAchievManager {
	private GenericDao<UserAchiev, Integer> daoInt = new GenericDaoImpl<>();
	private GenericDao<UserAchiev, String> daoStr = new GenericDaoImpl<>();
	@Context
	private HttpServletRequest httpServletRequest;

	@GET
	public List<UserAchiev> getUserAchievs() {
//		UserAchiev u = new UserAchiev();
//		u.setId(42);
//		u.setBattleTag("testBtag22222");
//		u.setUsername("UsernameTest");
		return daoInt.findAll(UserAchiev.class);
//		List<UserAchiev> res = new ArrayList<>();
//		res.add(u);
//		System.out.println(res);
//		return res;
	}

	@Path("/usersession")
	@GET
	public UserAchiev getUserAchievById() {
		UserAchiev u = new UserAchiev();
		u.setBattleTag("testBtag");
		u.setUsername("UsernameTest");
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("UserConnected", u);
		UserAchiev res = (UserAchiev) session.getAttribute("UserConnected");
		System.out.println(res.getBattleTag());

		System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
		return res;

	}

	@Path("/signin")
	@POST
	public Response addUserAchiev(UserAchiev u) {
		Response res = null;
		List<String> errs = CheckUser.check(u);
		System.out.println("test");
		try {
			
			if (!errs.isEmpty()) {
				return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
			}

			UserAchiev isPresent = daoStr.findByAttr(UserAchiev.class, "BattleTag", u.getBattleTag());

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
	public Response connexion(UserAchiev u) {
		List<String> errs = new ArrayList<>();

		UserAchiev UserAchiev = daoStr.findByAttr(UserAchiev.class, "BattleTag", u.getBattleTag());

		if (UserAchiev == null) {
			errs.add("UserAchiev inconnu");
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		// TODO encrypt
		if (UserAchiev.getPassword().trim().equals(u.getPassword().trim())) {
			// mise en sessions
			HttpSession session = httpServletRequest.getSession();

			session.setAttribute("UserAchiev", UserAchiev);

			return Response.ok().build();
		}
		errs.add("Mot de passe incorrect");
		return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();

	}

	@Path("/modification")
	@PUT
	public Response updateUserAchiev(UserAchiev u) {
		HttpSession session = httpServletRequest.getSession();
		UserAchiev UserAchiev = (UserAchiev) session.getAttribute("UserAchiev");
		List<String> errs = CheckUser.check(u);
		if (!errs.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		// TODO encrypt
		UserAchiev.setPassword(u.getPassword());
		UserAchiev.setBattleTag(u.getBattleTag());
		UserAchiev.setEvent(u.getEvent());
		UserAchiev.setUsername(u.getUsername());

		try {
			daoInt.update(UserAchiev);
		} catch (Exception e) {
			errs.add("Erreur serveur");
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		return Response.ok().build();
	}

	@Path("/desinscription")
	@DELETE
	public Response deleteUserAchiev() {
		HttpSession session = httpServletRequest.getSession();
		UserAchiev UserAchiev = (UserAchiev) session.getAttribute("UserAchiev");
		List<String> errs = new ArrayList<>();

		session.setAttribute("UserAchiev", null);

		try {
			daoInt.delete(UserAchiev);
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
		session.setAttribute("UserAchiev", null);
	}

}
