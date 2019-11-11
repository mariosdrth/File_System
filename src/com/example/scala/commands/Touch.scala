package com.example.scala.commands
import com.example.scala.files.{DirEntry, File}
import com.example.scala.filesystem.State

class Touch(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    File.emoty(state.wd.path, name)
}
