package com.example.scala.filesystem

import com.example.scala.commands.Command
import com.example.scala.files.Directory

object FileSystem extends App {

  val root = Directory.ROOT
  val initialState = State(root, root)
  initialState.show

  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
    val newState = Command.from(newLine).apply(currentState)
    newState.show
    newState
  })

//  var state = State(root, root)
//  val scanner = new Scanner(System.in)
//
//  while(true) {
//    state.show
//    val input = scanner.nextLine()
//    state = Command.from(input).apply(state)
//  }


}
