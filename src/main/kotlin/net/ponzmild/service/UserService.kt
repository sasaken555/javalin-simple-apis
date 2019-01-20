package net.ponzmild.service

import net.ponzmild.entity.UserEntity
import io.javalin.Context
import net.ponzmild.repository.UserRepository

class UserService {

    private val userRepository = UserRepository()

    fun getUsers(ctx: Context): Context {
        return ctx.json(userRepository.findAll())
    }

    fun getUserById(ctx: Context): Context {
        val userId = ctx.validatedPathParam("user-id").asInt().getOrThrow()
        val users = userRepository.findById(userId) ?: arrayListOf<UserEntity>()
        return ctx.json(users)
    }

    fun getUserByEmail(ctx: Context): Context {
        val email = ctx.validatedPathParam("email").notNullOrEmpty().getOrThrow()
        val users = userRepository.findByEmail(email) ?: arrayListOf<UserEntity>()
        return ctx.json(users)
    }

    fun createUser(ctx: Context): Context {
        val user = ctx.body<UserEntity>()
        userRepository.save(user.name, user.email)
        return ctx.status(201)
    }

    fun updateUser(ctx: Context): Context {
        val userId = ctx.validatedPathParam("user-id").asInt().getOrThrow()
        val user = ctx.body<UserEntity>()
        userRepository.update(userId, user)
        return ctx.status(204)
    }

    fun deleteUser(ctx: Context): Context {
        val userId = ctx.validatedPathParam("user-id").asInt().getOrThrow()
        userRepository.delete(userId)
        return ctx.status(204)
    }

}