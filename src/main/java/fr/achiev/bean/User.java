package fr.achiev.bean;


@javax.persistence.Entity
@javax.annotation.Generated("com.genmymodel.jpa")
public class User implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    private java.lang.Integer id;
    
    private java.lang.String Username;
    
    private java.lang.String BattleTag;
    
    private java.lang.String Server;
    
    private java.lang.String Faction;
    

    
    @javax.persistence.OneToMany(
        
    )
    java.util.Collection<Event> event;

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
    public void setServer(java.lang.String Server) {
        this.Server = Server;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.lang.String getServer() {
        return this.Server;
    }
    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setFaction(java.lang.String Faction) {
        this.Faction = Faction;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.lang.String getFaction() {
        return this.Faction;
    }
    

    @javax.annotation.Generated("com.genmymodel.jpa")
    public void setEvent(java.util.Collection<Event> event) {
        this.event = event;
    }
    
    @javax.annotation.Generated("com.genmymodel.jpa")
    public java.util.Collection<Event> getEvent() {
        return this.event;
    }
    
}

