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

    public Team(String name) throws InvalidTeamException
    {
        String nameToCheck = "";
        teamName = name;
        for (int i = 0; i < teams.length; i++)
        {
            nameToCheck = teams[i];
            if (teamName.equals(teams[i]))
            {
                teamID = i;
                break;
            }
        }
        if(!name.equals(nameToCheck))
        {
            throw new InvalidTeamException("Invalid NBA team entered, please enter a valid NBA team.");
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

}
