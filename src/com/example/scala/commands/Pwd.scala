package com.example.scala.commands
import com.example.scala.filesystem.State

class Pwd extends Command {

  override def apply(state: State): State = {
    state.setMessage(state.wd.path)
  }
}
