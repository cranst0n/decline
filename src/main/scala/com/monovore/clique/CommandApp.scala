package com.monovore.clique

class CommandApp(name: String, header: String, options: Opts[Unit]) {

  def main(args: Array[String]): Unit = {
    val command = Command(name, header, options).withHelp
    Parse.run(args.toList, command.options)
      .valueOr { errors =>
        errors.foreach(System.err.println)
        System.err.println(Help.render(command))
      }
  }
}