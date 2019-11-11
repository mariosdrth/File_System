package com.example.scala.commands
import com.example.scala.files.{DirEntry, Directory}
import com.example.scala.filesystem.State

class Mkdir(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)
}
