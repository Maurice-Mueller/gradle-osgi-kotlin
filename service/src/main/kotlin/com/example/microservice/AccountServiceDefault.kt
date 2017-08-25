package com.example.microservice

import com.example.microservice.api.Account
import com.example.microservice.service.AccountService

class AccountServiceDefault : AccountService {

  override fun simpleString(): String {
    return "<h1>Hello World!</h1>"
  }

  private val accounts = arrayListOf<Account>(
    Account(1, "Moe", "moe@example.com"),
    Account(1001, "Moe", "other-moe@example.com"),
    Account(2, "Pad", "pad@example.com"),
    Account(3, "Droid", "droid@example.com")
  )

  private val nullAccount = Account(0, "No Account Found", "-")

  override fun findById(id: Int): Account {
    return accounts.find { it.id == id }?:nullAccount
  }

  override fun findAll(): List<Account> {
    return accounts.toList()
  }

  override fun findAllByName(name: String): List<Account> {
    val matching = accounts.filter { it.name == name }
    return when(matching.isEmpty()) {
      true -> listOf(nullAccount)
      false -> matching
    }
  }

  override fun add(account: Account): String {
    accounts.add(account)
    return "OK"
  }
}
