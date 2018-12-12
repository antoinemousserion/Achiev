package fr.achiev.bean;


@javax.persistence.Entity
@javax.annotation.Generated("com.genmymodel.jpa")
public class Event implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    private java.lang.Integer id;
    
    private java.util.Date Day;
    
    private java.lang.String Hour;
    
    private java.lang.String Description;
    
    private java.lang.Integer Creator;
    

    
    @javax.persistence.OneToOne(
        fetch = javax.persistence.FetchType.LAZY
    )
    Achievement achievement;
    @javax.persistence.OneToMany(
        
    )
    java.util.Collection<UserAchiev> UserAchiev;

    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setId(java.lang.Integer id) {
        this.id = id;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.lang.Integer getId() {
        return this.id;
    }
    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setDay(java.util.Date Day) {
        this.Day = Day;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.util.Date getDay() {
        return this.Day;
    }
    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setHour(java.lang.String Hour) {
        this.Hour = Hour;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.lang.String getHour() {
        return this.Hour;
    }
    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setDescription(java.lang.String Description) {
        this.Description = Description;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.lang.String getDescription() {
        return this.Description;
    }
    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setCreator(java.lang.Integer Creator) {
        this.Creator = Creator;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.lang.Integer getCreator() {
        return this.Creator;
    }
    

    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public Achievement getAchievement() {
        return this.achievement;
    }
    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setUserAchiev(java.util.Collection<UserAchiev> UserAchiev) {
        this.UserAchiev = UserAchiev;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.util.Collection<UserAchiev> getUserAchiev() {
        return this.UserAchiev;
    }
    
}

