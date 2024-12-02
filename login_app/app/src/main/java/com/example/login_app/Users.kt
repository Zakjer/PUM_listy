package com.example.login_app

object DataProvider {
    var users = mutableListOf<User>(
        User("user1", "password1"),
        User("user2", "password2"),
        User("user3", "password3"),
        User("user4", "password4"),
    )

    fun getPredefinedUsers(): MutableList<User> {
        return users
    }

    fun addUserToList(login: String, password: String): MutableList<User> {
        users.add(User(login, password))
        return users
    }
}