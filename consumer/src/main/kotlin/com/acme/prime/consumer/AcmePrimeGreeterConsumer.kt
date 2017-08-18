package com.acme.prime.consumer

import com.acme.prime.services.AcmePrimeGreeter
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Reference

@Component
class AcmePrimeGreeterConsumer {

  @Reference
  private var greeter: AcmePrimeGreeter? = null

  @Activate
  fun activate() {
    println("AcmePrimeGreeterConsumer: activated")
    greeter?.greet()
  }

}
