package com.acme.prime

import com.acme.prime.services.AcmePrimeGreeter
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Deactivate


@Component
class AcmePrimeGreeterDefault: AcmePrimeGreeter {

  override fun greet() {
    println("AcmePrimeGreeterDefault: Greetings, earther.")
  }

  @Activate
  fun activate() {
    println("AcmePrimeGreeterDefault: activated.")
  }

  @Deactivate
  fun deactivate() {
    println("AcmePrimeGreeterDefault: deactivated.")
  }

}

