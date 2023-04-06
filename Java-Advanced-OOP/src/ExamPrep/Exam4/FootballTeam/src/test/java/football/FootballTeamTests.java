package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class FootballTeamTests {
    private FootballTeam footballTeam;
    private Collection<FootballTeam> footballers;

    @Before
    public void setup() {
        footballers = new ArrayList<>();
    }

    @Test(expected = NullPointerException.class)
    public void TestIfGivenNameIsNull() {
        FootballTeam footballTeam = new FootballTeam(null, 10);
        footballers.add(footballTeam);
        Assert.assertEquals("Barcelona", footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void TestIfGivenNameIsWhiteSpace() {
        FootballTeam footballTeam = new FootballTeam("", 10);
        footballers.add(footballTeam);
        Assert.assertEquals("Barcelona", footballTeam.getName());
    }

    @Test
    public void TestIfGivenNameIsValid() {
        FootballTeam footballTeam = new FootballTeam("Real Madrid", 10);
        footballers.add(footballTeam);
        Assert.assertEquals("Real Madrid", footballTeam.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestIfVacantSpotsAreNegative() {
        FootballTeam footballTeam = new FootballTeam("Real Madrid", -1);
        footballers.add(footballTeam);
        Assert.assertEquals(1, footballTeam.getVacantPositions());
    }

    @Test
    public void TestIfVacantSpotsAreAboveZero() {
        FootballTeam footballTeam = new FootballTeam("Real Madrid", 2);
        footballers.add(footballTeam);
        Assert.assertEquals(2, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddPlayerWhenNoSpotsAreLeft() {
        FootballTeam footballTeam = new FootballTeam("Real Madrid", 0);
        Footballer footballer = new Footballer("Cristiano Ronaldo");
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(footballTeam.getCount(), footballTeam.getVacantPositions());
    }

    @Test
    public void TestAddPlayerWithSpotsLeft() {
        FootballTeam footballTeam = new FootballTeam("Real Madrid", 1);
        Footballer footballer = new Footballer("Cristiano Ronaldo");
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(footballTeam.getCount(), 1);
    }

    @Test
    public void TestRemoveExistingPlayer() {
        FootballTeam footballTeam = new FootballTeam("Real Madrid", 3);
        Footballer footballer = new Footballer("Cristiano Ronaldo");
        Footballer footballer2 = new Footballer("Leonel Messi");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        footballTeam.removeFootballer("Leonel Messi");
        Assert.assertEquals(footballTeam.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveNonExistPlayer() {
        FootballTeam footballTeam = new FootballTeam("Real Madrid", 3);
        Footballer footballer = new Footballer("Cristiano Ronaldo");
        Footballer footballer2 = new Footballer(null);
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        footballTeam.removeFootballer("Neymar");
    }

    @Test
    public void TestSetPlayerForSale() {
        FootballTeam footballTeam = new FootballTeam("Real Madrid", 3);
        Footballer footballer = new Footballer("Cristiano Ronaldo");
        Footballer footballer2 = new Footballer("Leonel Messi");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        Footballer sellingPlayer = footballTeam.footballerForSale("Leonel Messi");
        Assert.assertFalse(sellingPlayer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleNonExisting() {
        Footballer footballer1 = new Footballer("Lionel Messi");
        FootballTeam footballTeam = new FootballTeam("Barcelona", 1);

        footballTeam.addFootballer(footballer1);
        footballTeam.footballerForSale("Cristiano Ronaldo");
    }

    @Test
    public void TestGetStatistic() {
        FootballTeam footballTeam = new FootballTeam("Real Madrid", 2);
        Footballer footballer = new Footballer("Cristiano Ronaldo");
        Footballer footballer2 = new Footballer("Leonel Messi");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        Assert.assertEquals("The footballer Cristiano Ronaldo, Leonel Messi is in the team Real Madrid.", footballTeam.getStatistics());
    }
}