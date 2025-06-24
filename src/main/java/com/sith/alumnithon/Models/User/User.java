package com.sith.alumnithon.Models.User;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sith.alumnithon.Models.Interest.Interest;
import com.sith.alumnithon.Models.Language.UserLanguageInterest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sith.alumnithon.Models.Event.Event;
import com.sith.alumnithon.Models.Language.UserLanguageSpoken;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_app", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails{

    private @Id @GeneratedValue Long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "country")
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToMany(mappedBy = "moderator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Event> createdEvents;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLanguageSpoken> languagesSpoken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLanguageInterest> languagesInterest;

    @ManyToMany
    @JoinTable(
        name = "user_following",
        joinColumns = @JoinColumn(name = "follower_id"),
        inverseJoinColumns = @JoinColumn(name = "followed_id")

    )
    private Set<User> following = new HashSet<>();

    @ManyToMany(mappedBy = "following")
    private Set<User> followers = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "user_event",
        joinColumns =  @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Event> events = new HashSet<>();


    public void follow(User userToFollow) {
        this.following.add(userToFollow);
        userToFollow.getFollowers().add(this);
    }

    public void unfollow(User userToUnfollow) {
        this.following.remove(userToUnfollow);
        userToUnfollow.getFollowers().remove(this);
    }

    @ManyToMany
    @JoinTable(
            name = "user_interest",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<Interest> interests = new HashSet<>();

    // Setters and Getters
    
    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<UserLanguageSpoken> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(List<UserLanguageSpoken> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public void setCreatedEvents(List<Event> createdEvents) {
        this.createdEvents = createdEvents;
    }

    public List<UserLanguageInterest> getLanguagesInterest() {
        return languagesInterest;
    }

    public void setLanguagesInterest(List<UserLanguageInterest> languagesInterest) {
        this.languagesInterest = languagesInterest;
    }
}
