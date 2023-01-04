package io.github.rafafrdz.gmail

import cats.effect.unsafe.implicits.global
import io.github.rafafrdz.gmail.client.GMailClient
import io.github.rafafrdz.gmail.email.GMail
import io.github.rafafrdz.gmail.functions.gmail._

object ExampleApp extends App {

  /** Cliente */
  val gmail: GMailClient =
    GMailClient
      .build
      .user("email@gmail.com") // Gmail Account
      .password("password") // Gmail Password
      .ssl
      .create

  /** (Body) Mensaje */
  val mssg: String = "Hello! This is the body for this mail"

  /** Mail */
  val mail: GMail =
    from("Sender", "email@gmail.com")
      .to("Receiver", "to@gmail.com")
      .cc("Copy", "cc@gmail.com")
      .bcc("Hide Copy", "bcc@gmail.com")
      .subject("subject")
      .body(mssg)
      .end

  /** Enviar */
  gmail.sendUnsafe(mail)

}
