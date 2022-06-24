package com.techreturners

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class AppTest extends AnyFlatSpec with Matchers{

"The total word Score" should "be 10 for the word GUARDIAN"in{

  val newGame=new Scrabble("GUARDIAN")
  assert(newGame.totalScore==10)
}

  "The  random tiles generated " should "have same length as input size given"in{
    val newGame=new Scrabble()
    val newPlayer= new Player("Lakshmi",7)
    assert(newPlayer.randomWord.length==7)
    newGame.play(newPlayer)
  }
}
