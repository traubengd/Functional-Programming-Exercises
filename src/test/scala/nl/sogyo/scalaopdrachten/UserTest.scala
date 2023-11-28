package nl.sogyo.scalaopdrachten

import nl.sogyo.scalaopdrachten.User

class UserTest extends munit.FunSuite:
    test("New user has the correct password") {
        val user = User("Piet", "geheim")
        assertEquals(user.getPassword(), "geheim")
    }

    test("User can change their password") {
        val user = User("Piet", "geheim")
        .changePassword("secret")
        assertEquals(user.getPassword(), "secret")
    }

    test("User cannot change password into current password") {
        val user = User("Piet", "geheim")
        intercept[InvalidPasswordException](user.changePassword("geheim"))
    }

    test("User cannot change password into any previous password") {
        val user = User("Piet", "geheim")
        .changePassword("secret")
        .changePassword("welkom")
        .changePassword("123456")
        intercept[InvalidPasswordException](user.changePassword("geheim"))
        intercept[InvalidPasswordException](user.changePassword("secret"))
        intercept[InvalidPasswordException](user.changePassword("welkom"))
        intercept[InvalidPasswordException](user.changePassword("123456"))
    }
