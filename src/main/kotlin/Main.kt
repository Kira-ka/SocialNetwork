import WallService.add
import WallService.posts
import WallService.update
import kotlin.random.Random

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean,

    )

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val text: String,
    val friendsOnly: Boolean,
    val comments: Comments,
    val reposts: Reposts,
    val postType: String,
    val canPin: Boolean
)

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val postWithId = post.copy(id = Random.nextInt(1, 100))
        posts += postWithId
        return posts.last()
    }


    fun update(post: Post): Boolean {
        var bool = true
        for ((index, post1) in posts.withIndex()) {
            if (post1.id == post.id) {
                posts[index] = post.copy(text = "пост обновлен")
                bool = true
            } else bool = false
        }
        return bool
    }

    fun clear() {
        posts = emptyArray()
    }
}

fun main(args: Array<String>) {
    val post1 = Post(
        0,
        123,
        321,
        123,
        "какойто текст",
        true,
        Comments(0, true, false, true, true),
        Reposts(10, true),
        "post",
        true
    )

    val post2 = WallService.add(post1)
    WallService.update(post2)

}
