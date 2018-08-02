package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Jason on 7/31/2018.
 */
public class Team
{
    private String teamName;
    private int teamID;

    private String[] teams = {"Hawks", "Celtics", "Nets", "Hornets", "Bulls", "Cavaliers", "Mavericks", "Nuggets", "Pistons", "Warriors", "Rockets", "Pacers",
        "Clippers", "Lakers", "Grizzlies", "Heat", "Bucks", "Timberwolves", "Pelicans", "Knicks", "Thunder", "Magic", "76ers", "Suns", "Blazers", "Kings", "Spurs",
        "Raptors", "Jazz", "Wizards"};

    private String[] players = {"Jaylen Adams", "Kyrie Irving", "D'Angelo Russell", "Kemba Walker", "Cameron Payne", "Jordan Clarkson", "Dennis Smith Jr.", "Jamal Murray",
            "Reggie Jackson", "Stephen Curry", "Chris Paul", "Darren Collison", "Patrick Beverley", "Lonzo Ball", "Mike Conley", "Goran Dragic", "Brandon Jennings",
            "Jeff Teague", "Jrue Holiday", "Emmanuel Mudiay", "Russell Westbrook", "D.J. Augustin", "Ben Simmons", "Brandon Knight", "Damian Lillard", "De'Aaron Fox",
            "Patty Mills", "Kyle Lowry", "Ricky Rubio", "John Wall"};

    public Team(String name)
    {
        teamName = name;
        for(int i = 0; i < teams.length; i++)
        {
            if(teamName.equals(teams[i]))
            {
                teamID = i;
                break;
            }
        }
    }

    public String getPlayerName()
    {
        return players[teamID];
    }

    public String getTeamName()
    {
        return teamName;
    }

    public static void main(String[] args)
    {
        Team t = new Team("Lakers");
        System.out.println(t.getPlayerName());
        Random d = new Random();
        System.out.println(d.nextInt(2) + 2);
    }

}
