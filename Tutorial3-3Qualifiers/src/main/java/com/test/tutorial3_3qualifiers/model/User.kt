package com.test.tutorial3_3qualifiers.model

class User(var name: String = "Unknown",
           var email: String = "abc@xyz.com") {

    override fun toString(): String {
        return "name: $name, email: $email"
    }
}