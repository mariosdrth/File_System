package com.example.scala.commands

import com.example.scala.filesystem.State

trait Command {

  def apply(state: State): State

}

object Command {

  val MKDIR = "mkdir"

  def emptyCommand: Command = (state: State) => state
  def incompleteCommand(name: String): Command = (state: State) => state.setMessage(s"$name: incomplete command!")
  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    } else new UnknownCommand
  }
}