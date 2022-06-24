package com.techreturners

import scala.collection.mutable.ListBuffer
import scala.io.Source


class Scrabble(word:String="") {
   val rackWord:String=word
   val totalScore:Int=calculateScore(rackWord)
   val dictionaryFile= Source.fromFile("/home/abpgcp/GPractice_codes/lm-code-kata-scala-scrabble/src/main/scala/com/techreturners/dictionary.txt")
   val dictionaryData:List[String]=dictionaryFile.getLines().toList
   dictionaryFile.close()

  def play(player:Player,data:List[String]=dictionaryData): List[String] ={
     val randomTiles:Array[Char]=player.randomWord
    println(randomTiles.toList)
     val wordsInDictionary:ListBuffer[String]=new ListBuffer[String]()
     for (word<-data) {
       val lettersPresent: ListBuffer[Char] = new ListBuffer[Char]()
       for (letter <- word.toUpperCase) {
         if (randomTiles.contains(letter))
           lettersPresent += letter
       }
       if (lettersPresent.length == word.length)
         wordsInDictionary += word
     }
      println(wordsInDictionary)
    wordsInDictionary.toList
   }
  def calculateScore(str: String):Int={
    val word:String=str
    var score:Int=0
    for (i<-word){
       val letterScore:Int=i.toString match {
        case "A" | "E" | "I" | "O" | "U" | "N" | "R" | "T" | "L" | "S" => 1
        case "D" | "G" => 2
        case "B"|"C"|"M"|"P"=>3
        case "F"|"H"|"V"|"W"|"Y"=>4
        case "K"=>5
        case "J"|"X"=>8
        case "Q"|"Z"=>10
      }
      score+=letterScore
    }
    score
  }




}
