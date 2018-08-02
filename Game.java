package game;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.Random;

/**
 * Created by Jason on 8/1/2018.
 */
public class Game
{
    private int maxPoints;
    private int playerOneCurrentPoints;
    private int playerTwoCurrentPoints;
    private boolean isHeads;
    private boolean playerOneTurn;
    private boolean playerTwoTurn;
    private String playerOne;
    private String playerTwo;

    public Game(int maxPoints)
    {
        this.maxPoints = maxPoints;
        playerOneCurrentPoints = 0;
        playerTwoCurrentPoints = 0;
    }

    public void playGame()
    {
        Random ran = new Random();
        while(playerOneCurrentPoints < maxPoints && playerTwoCurrentPoints < maxPoints)
        {

           if(playerOneGoesFirst() && playerOneTurn)
           {
               if(!playerScoresTwo() && !playerScoresThree())
               {
                   playerOneCurrentPoints = playerOneCurrentPoints + 0;
                   System.out.println(playerOne + " has missed");
                   System.out.println(playerOne + " : " + playerOneCurrentPoints + " vs. " + playerTwo + " : " + playerTwoCurrentPoints);
                   playerOneTurn = false;
                   playerTwoTurn = true;
               }
               else if (playerScoresTwo())
               {
                   playerOneCurrentPoints = playerOneCurrentPoints + 2;
                   System.out.println(playerOne + " has scored 2!");
                   System.out.println(playerOne + " : " + playerOneCurrentPoints + " vs. " + playerTwo + " : " + playerTwoCurrentPoints);
                   playerOneTurn = false;
                   playerTwoTurn = true;
               }
               else
               {
                   playerOneCurrentPoints = playerOneCurrentPoints + 3;
                   System.out.println(playerOne + " has scored 3!");
                   System.out.println(playerOne + " : " + playerOneCurrentPoints + " vs. " + playerTwo + " : " + playerTwoCurrentPoints);
                   playerOneTurn = false;
                   playerTwoTurn = true;
               }

           }

            if(playerOneGoesFirst() && playerTwoTurn)
            {
                if(!playerScoresTwo() && !playerScoresThree())
                {
                    playerTwoCurrentPoints = playerTwoCurrentPoints + 0;
                    System.out.println(playerTwo + " has missed");
                    System.out.println(playerOne + " : " + playerOneCurrentPoints + " vs. " + playerTwo + " : " + playerTwoCurrentPoints);
                    playerOneTurn = true;
                    playerTwoTurn = false;
                }
                else if (playerScoresTwo())
                {
                    playerTwoCurrentPoints = playerTwoCurrentPoints + 2;
                    System.out.println(playerTwo + " has scored 2!");
                    System.out.println(playerOne + " : " + playerOneCurrentPoints + " vs. " + playerTwo + " : " + playerTwoCurrentPoints);
                    playerOneTurn = true;
                    playerTwoTurn = false;
                }
                else
                {
                    playerTwoCurrentPoints = playerTwoCurrentPoints + 3;
                    System.out.println(playerTwo + " has scored 3!");
                    System.out.println(playerOne + " : " + playerOneCurrentPoints + " vs. " + playerTwo + " : " + playerTwoCurrentPoints);
                    playerOneTurn = true;
                    playerTwoTurn = false;
                }
            }

        }
    }

    public boolean coinToss()
    {
        Random random = new Random();
        int someNumber = random.nextInt(10);
        if(someNumber > 5)
        {
            isHeads = true;
        }
        else
        {
            isHeads = false;
        }
        return isHeads;
    }

    public boolean playerOneGoesFirst()
    {
        if(coinToss())
        {
            playerOneTurn = true;
            return true;
        }
        else
        {
            playerTwoTurn = true;
            return false;
        }
    }

    public boolean playerScoresTwo()
    {
        Random ran = new Random();
        if(ran.nextInt(4) == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean playerScoresThree()
    {
        Random ran = new Random();
        if(ran.nextInt(4) == 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setPlayerOne(String name)
    {
        playerOne = name;
    }

    public void setPlayerTwo(String name)
    {
        playerTwo = name;
    }

    public String winner()
    {
        if(playerOneCurrentPoints > playerTwoCurrentPoints)
        {
            return playerOne + " is the winner!";
        }
        else
        {
            return playerTwo + " is the winner!";
        }
    }

    public static void main(String[] args)
    {
        try {
            Team team1 = new Team("Rockets");
            Team team2 = new Team("Warriors");
            Game game = new Game(25);
            game.setPlayerOne(team1.getPlayerName());
            game.setPlayerTwo(team2.getPlayerName());
            game.playGame();
            System.out.println(game.winner());
        }
        catch (InvalidTeamException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
