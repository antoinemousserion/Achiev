package fr.achiev.aut;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import fr.achiev.bean.UserAchiev;

public class CheckUser {
	/**
	 * @param UserAchiev
	 * @return la liste des messages d'erreurs lors du check de l'UserAchiev
	 */
	public static List<String> check(UserAchiev u) {
		List<String> res = new ArrayList<>();
		if (!checkBattleTag(u.getBattleTag())) {
			res.add("Your BattleTag must be like 'letters#number'.");
		}
		if (!checkUsername(u.getUsername())) {
			res.add("Your Username must not be Empty.");
		}
		return res;

	}

	private static boolean checkBattleTag(String btag) {
		if (Pattern.matches("[a-z]*#[0-9]*", btag.toLowerCase())) {
			return true;
		}
		return false;
	}
	private static boolean checkUsername(String username) {
		if (username!=null && username.length()>0) {
			return true;
		}
		return false;
	}
	public static boolean isConnected(HttpSession session) {
		if(session.getAttribute("UserConnected") != null) {
			return true;
		}
		return false;
	}
}
