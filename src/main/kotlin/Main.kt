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
    val date: Int,
    val fromId: Int,
    val createdBy: Int?,
    val text: String?,
    val friendsOnly: Boolean,
    val comments: Comments?,
    val reposts: Reposts,
    val postType: String,
    val canPin: Boolean

)

object WallService {
    private var idCounter: Int = 0
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val postWithId = post.copy(id = idCounter)
        posts += postWithId
        idCounter += 1
        return posts.last()
    }


    fun update(post: Post): Boolean {
        for ((index, existing) in posts.withIndex()) {
            if (existing.id == post.id) {
                posts[index] = post.copy(
                    ownerId = existing.ownerId,
                    date = existing.date,
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
        765,
        "какойто текст2",
        false,
        Comments(0, true, false, true, true),
        Reposts(10, true),
        "post",
        true
    )

    WallService.add(post1)
    WallService.add(post2)
    WallService.update(post1)

}
