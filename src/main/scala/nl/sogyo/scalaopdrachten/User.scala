package nl.sogyo.scalaopdrachten

class User(private val username: String, private val password: String, private val previousPasswords: List[String]):

    def getUserName(): String = this.username

    def getPassword(): String = this.password

    def changePassword(newPassword: String): User =
        if previousPasswords.contains(newPassword) || newPassword.equals(password) then
            throw new InvalidPasswordException(
              s"You already used the password \"${newPassword}\""
            )
        else
           new User(username, newPassword, previousPasswords :+ password) 

object User: 
    def apply (username : String, password : String) = new User(username, password, Nil)

class InvalidPasswordException(msg: String) extends Exception(msg)
