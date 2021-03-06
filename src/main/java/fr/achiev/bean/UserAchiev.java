package fr.achiev.bean;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity
@javax.annotation.Generated("com.genmymodel.jpa")
public class UserAchiev implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private java.lang.Integer id;

	private java.lang.String Username;

	private java.lang.String Password;

	private java.lang.String BattleTag;

	@javax.persistence.OneToMany(

	)
	List<Event> event;

	@javax.annotation.Generated("com.genmymodel.jpa")
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	@javax.annotation.Generated("com.genmymodel.jpa")
	public java.lang.Integer getId() {
		return this.id;
	}

	@javax.annotation.Generated("com.genmymodel.jpa")
	public void setUsername(java.lang.String Username) {
		this.Username = Username;
	}

	@javax.annotation.Generated("com.genmymodel.jpa")
	public java.lang.String getUsername() {
		return this.Username;
	}

	@javax.annotation.Generated("com.genmymodel.jpa")
	public void setBattleTag(java.lang.String BattleTag) {
		this.BattleTag = BattleTag;
	}

	@javax.annotation.Generated("com.genmymodel.jpa")
	public java.lang.String getBattleTag() {
		return this.BattleTag;
	}

	@javax.annotation.Generated("com.genmymodel.jpa")
	public void setEvent(List<Event> event) {
		this.event = event;
	}

	@javax.annotation.Generated("com.genmymodel.jpa")
	public List<Event> getEvent() {
		return this.event;
	}

	public java.lang.String getPassword() {
		return Password;
	}

	public void setPassword(java.lang.String password) {
		Password = password;
	}

}
