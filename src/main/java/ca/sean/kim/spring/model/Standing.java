package ca.sean.kim.spring.model;

import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Created by 37264 on 5/19/16.
 */
//@ComponentScan({ "ca.sean.kim.spring.configuration" })
@Entity
@Table(name = "STANDING")
public class Standing extends BaseModel implements Serializable
{
    @Column(name = "CITY")
    private String city;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "WON")
    private long won;

    @Column(name = "LOST")
    private long lost;

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(final String teamName) {
        this.teamName = teamName;
    }

    public long getWon() {
        return won;
    }

    public void setWon(final long won) {
        this.won = won;
    }

    public long getLost() {
        return lost;
    }

    public void setLost(final long lost) {
        this.lost = lost;
    }
}
