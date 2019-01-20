import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import service.UserService
import java.lang.Exception

fun main(args: Array<String>) {

    val app = Javalin.create().apply {
        // not-used parameter "ctx" can be replaced with "_"
        exception(Exception::class.java) { e, _ -> e.printStackTrace() }
        error(404) { it.json("not found") }
    }.start(7000)

    // TODO: いちいちnewしないで, Dependency Injection使う
    val userService = UserService()

    app.routes {
        path("/users") {
            get { userService.getUsers(it) }
            get("/:user-id") { userService.getUserById(it) }
            get("/email/:email") { userService.getUserByEmail(it) }
            post { userService.createUser(it) }
            patch("/:user-id") { userService.updateUser(it) }
            delete("/:user-id") { userService.deleteUser(it) }
        }
    }
}
