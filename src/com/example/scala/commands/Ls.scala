package com.example.scala.commands
import com.example.scala.files.DirEntry
import com.example.scala.filesystem.State

class Ls extends Command {

  override def apply(state: State): State = {
    val contents = state.wd.contents
    val niceOutput = createNiceOutput(contents)
    state.setMessage(niceOutput)
  }

  def createNiceOutput(contents: List[DirEntry]): String = {
    if (contents.isEmpty) ""
    //contents.head.name + Directory.SEPARATOR + createNiceOutput(contents.tail)
    else {
      val entry = contents.head
      s"${entry.name}[${entry.getType}]\n${createNiceOutput(contents.tail)}"
    }
  }
}
