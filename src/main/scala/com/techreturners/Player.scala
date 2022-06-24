package com.techreturners
import scala.collection.mutable.ListBuffer
import scala.util.Random


class Player (playerId:String,size:Int){
 val player:String= playerId
 val rackSize:Int=size
 val random=new Random
 //val i:Char="".charAt(0)//Empty Char in Scala
 val randomWord:Array[Char]=createRack(rackSize,random)


 def createRack(size:Int,random:Random):Array[Char]={
  val rack:Array[Char]=new Array[Char](size)
  val bagStatus=Map('A'->9,'I'->9,'E'->12,'O'->8,'N'->6,'R'->6,'T'->6,'L'->4,'S'->4,'U'->4,'D'->4,'G'->3,'K'->1,'J'->1,'X'->1,'Q'->1,'Z'->1,'B'->2,'C'->2,'M'->2,'P'->2,'F'->2,'H'->2,'V'->2,'W'->2,'Y'->2)
  val alphabetList:List[Char]=('A'to'Z').toList
  var bagList:ListBuffer[String]=ListBuffer()

  for((key,value)<-bagStatus){
    val newList:String=key.toString*value
     bagList+=newList
  }
  val bagOfTiles=bagList.mkString
  for (i<-0 until size) {
   rack(i) =bagOfTiles(random.nextInt(bagOfTiles.length))
  }
  rack
 }


}
