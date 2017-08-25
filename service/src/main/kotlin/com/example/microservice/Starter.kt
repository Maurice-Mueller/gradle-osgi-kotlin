package com.example.microservice

import com.example.microservice.service.AccountService
import org.apache.cxf.endpoint.Server
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Deactivate
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import com.fasterxml.jackson.module.kotlin.KotlinModule


@Component(immediate = true)
class Starter {

  private val sf = JAXRSServerFactoryBean()
  private var server: Server? = null

  @Activate
  fun activated() {
    println("JAX-RS server is going to be started...")

    val mapper = ObjectMapper().registerModule(KotlinModule())
    sf.setResourceClasses(AccountService::class.java)
    sf.setResourceProvider(AccountService::class.java,
    SingletonResourceProvider(AccountServiceDefault()))
    sf.setProvider(JacksonJsonProvider(mapper));
    sf.setAddress("http://localhost:9999/")
    server = sf.create()
  }

  @Deactivate
  fun deactivated() {
    server!!.stop()
    server!!.destroy()
    println("Server stopped")
  }
}
