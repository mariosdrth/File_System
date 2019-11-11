package com.example.scala.filesystem

import java.util.Scanner

import com.example.scala.commands.Command
import com.example.scala.files.Directory

object FileSystem extends App {

  val root = Directory.ROOT
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while(true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }


}
