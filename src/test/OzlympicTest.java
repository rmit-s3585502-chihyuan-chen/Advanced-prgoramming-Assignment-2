package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import OzlympicGames.Games;
import OzlympicGames.Ozlympic;;

public class OzlympicTest {

 @BeforeClass
 public static void setUpBeforeClass() throws Exception {
 }

 @AfterClass
 public static void tearDownAfterClass() throws Exception {
 }

 @Before
 public void setUp() throws Exception {
 }

 @After
 public void tearDown() throws Exception {
 }

 @Test
 public void testSelectGame1() {
  Games newGame = Ozlympic.selectGame(1);
  assertEquals("Swimming", newGame.GameType());
 }
 @Test
 public void testSelectGame2() {
  Games newGame = Ozlympic.selectGame(2);
  assertEquals("Cycling", newGame.GameType());
 }
 @Test
 public void testSelectGame3() {
  Games newGame = Ozlympic.selectGame(3);
  assertEquals("Running", newGame.GameType());
 }
}