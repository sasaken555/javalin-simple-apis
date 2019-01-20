package repository

import entity.UserEntity
import java.util.concurrent.atomic.AtomicInteger

class UserRepository {

    /*
        class ArrayList<E> : MutableList<E>, RandomAccess
        valで再宣言はできないが, 要素の書き換えは可能のようだ
    */
    private val users = arrayListOf(
        UserEntity("Alice", "alice@alice.kt", 0),
        UserEntity("Bob", "boku_bob@jp.bobbob.net", 1),
        UserEntity("Carol", "christmas-carol@gmail.com", 2),
        UserEntity("David", "dave@u2.uk", 3)
    )

    /*
        A counter to increment
        See https://docs.oracle.com/javase/jp/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html
    */
    var lastId: AtomicInteger = AtomicInteger(users.size)

    fun findAll(): ArrayList<UserEntity> {
        return users
    }

    fun findById(id: Int): UserEntity? {
        return users.find { it.id == id }
    }

    fun findByEmail(email: String): UserEntity? {
        return users.find { it.email == email }
    }

    fun save(name: String, email: String) {
        val id = lastId.incrementAndGet()
        users.add(UserEntity(name, email, id))
    }

    fun update(id: Int, user: UserEntity) {
        val idx = users.indexOfFirst { it.id == id }
        users.set(idx, user)
    }

    fun delete(id: Int) {
        val user = this.findById(id)
        users.remove(user)
    }

}