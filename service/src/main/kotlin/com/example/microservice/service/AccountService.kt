package com.example.microservice.service

import com.example.microservice.api.Account
import javax.ws.rs.*

@Path("/account/")
@Produces("application/json")
interface AccountService {

  @GET
  @Path("/{id}")
  @Produces("application/json")
  fun findById(@PathParam("id") id: Int): Account

  @GET
  @Path("/")
  @Produces("application/json")
  fun findAll(): List<Account>

  @GET
  @Path("/customer/{name}")
  @Produces("application/json")
  fun findAllByName(@PathParam("name") name: String): List<Account>

  @GET
  @Path("/simpleString")
  @Produces("text/html")
  fun simpleString(): String

  @POST
  @Path("/")
  @Consumes("application/json")
  @Produces("application/json")
  fun add(account: Account): String

}
