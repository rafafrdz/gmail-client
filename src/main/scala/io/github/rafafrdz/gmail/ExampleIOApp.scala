package io.github.rafafrdz.gmail

import cats.effect.{IO, IOApp}
import io.github.rafafrdz.gmail.client.GMailClient
import io.github.rafafrdz.gmail.email.GMail
import io.github.rafafrdz.gmail.functions.gmail._

object ExampleIOApp extends IOApp.Simple {

  /** Cliente */
  lazy val gmail: GMailClient =
    GMailClient
      .build
      .user("email@gmail.com") // Gmail Account
      .password("password") // Gmail Password
      .ssl
      .create

  /** (Body) Mensaje */
  val mssg: String = "Hello! This is the body for this mail"

  /** Mail */
  lazy val mail: GMail =
    from("Sender", "email@gmail.com")
      .to("Receiver", "to@gmail.com")
      .cc("Copy", "cc@gmail.com")
      .bcc("Hide Copy", "bcc@gmail.com")
      .subject("subject")
      .body(mssg)
      .end


  override def run: IO[Unit] = for {
    _ <- gmail.send(mail)
  } yield ()
}
