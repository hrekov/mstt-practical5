package akka

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor extends Actor {
  def receive: Receive = {
    case "hello" => println("hello back at you")
    case _       => println("huh?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  // default Actor constructor
  val helloActor = system.actorOf(Props.apply[HelloActor](), name = "helloactor")
  helloActor ! "hello"
  helloActor ! "buenos dias"
}

