package fr.achiev.bean;

import java.util.List;

@javax.persistence.Entity
@javax.annotation.Generated("com.genmymodel.jpa")
public class Achievement implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    private java.lang.Integer id;
    
    private java.lang.String Name;
    
    private java.lang.String Description;
    
    @javax.persistence.OneToMany(

    		)
    private List<UserAchiev> Subscribers;
    

    

    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setId(java.lang.Integer id) {
        this.id = id;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.lang.Integer getId() {
        return this.id;
    }
    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setName(java.lang.String Name) {
        this.Name = Name;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.lang.String getName() {
        return this.Name;
    }
    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setDescription(java.lang.String Description) {
        this.Description = Description;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.lang.String getDescription() {
        return this.Description;
    }

	public List<UserAchiev> getSubscribers() {
		return Subscribers;
	}

	public void setSubscribers(List<UserAchiev> subscribers) {
		Subscribers = subscribers;
	}
    

    
}

