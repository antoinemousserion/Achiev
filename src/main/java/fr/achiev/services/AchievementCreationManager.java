package fr.achiev.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import fr.achiev.bean.Achievement;
import fr.achiev.bean.UserAchiev;
import fr.achiev.dal.GenericDao;
import fr.achiev.dal.GenericDaoImpl;

@Path("/achievement")
public class AchievementCreationManager {
	
	private GenericDao<Achievement,Integer > achievementDAO;
	private GenericDao<UserAchiev, Integer> daoInt = new GenericDaoImpl<>();
	@Context
	private HttpServletRequest httpServletRequest;
	
	public AchievementCreationManager(){
		achievementDAO = new GenericDaoImpl<>();
    }

	
	@GET
    public List<Achievement> getAchievements()
    {
        List<Achievement> listeAchevements= achievementDAO.findAll(getClass());
        return listeAchevements;
        
    }
	
	@GET
    @Path("/{id:\\d+}")
    public Achievement getAchievement(@PathParam("id") int id)
    {    
        return achievementDAO.findById(Achievement.class, id);
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Achievement addAchievement(Achievement achievement)
    {
        try {
        	achievementDAO.add(achievement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return achievement;
    }
	
	@PUT
    @Path("/{id:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Achievement addSubscriber(@PathParam("id") int id, Achievement achievement)
    {    
		HttpSession session = httpServletRequest.getSession();
		UserAchiev UserActive = daoInt.findById(UserAchiev.class, (Integer)session.getAttribute("id"));
		
		
		//achievement.setId(id);
		Achievement temporaryAcievement = achievementDAO.findById(Achievement.class, id);
		List<UserAchiev> UsersAchiev = temporaryAcievement.getSubscribers();
		UsersAchiev.add(UserActive);
		temporaryAcievement.setSubscribers(UsersAchiev);
		
		///////// add new subscriber to the event
		
        try {
        	achievementDAO.update(temporaryAcievement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return achievement;
    }
	
	@DELETE
    @Path("/{id:\\d+}")
    public void deleteAchievement(@PathParam("id") int id)
    {
    	
        try {
        	achievementDAO.delete(getAchievement(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
