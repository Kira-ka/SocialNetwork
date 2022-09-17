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
    val id: Int = 0,
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
    private var id1: Int = 0
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val postWithId = post.copy(id = id1)
        posts += postWithId
        id1 += 1
        return posts.last()
    }


    fun update(post: Post): Boolean {
        for ((index, post1) in posts.withIndex()) {
            if (post1.id == post.id) {
                posts[index] = post.copy(
                    ownerId = +1,
                    fromId = +1,
                    createdBy = post.copy().ownerId + 1,
                    text = "пост обновлен",
                    friendsOnly = true,
                    comments = Comments(0, true, false, true, true),
                    reposts = Reposts(11, true),
                    postType = "post",
                    canPin = true
                )
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
    }
}

fun main(args: Array<String>) {
    val post1 = Post(
        8,
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
    val post2 = Post(
        3,
        765,
        987,
        4123,
        "какойто текст2",
        true,
        Comments(0, true, false, true, true),
        Reposts(10, true),
        "post",
        true
    )

    WallService.add(post1)
    WallService.add(post2)
    WallService.update(post1)

}
