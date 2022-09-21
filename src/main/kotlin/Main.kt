data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String
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
    val comments: Comment,
    val reposts: Reposts,
    val postType: String,
    val canPin: Boolean,
    val attachment: Array<Attachment> = emptyArray()
)


object WallService {
    private var idCounter: Int = 0
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((_, existing) in posts.withIndex()) {
            if (existing.id == postId) {
                comments += comment
                return comments.last()
            } else {
                throw PostNotFoundException("no post with id $postId ")
            }
        }
        return comment
    }

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
        Comment(40, 2224, 34, " text"),
        Reposts(10, true),
        "post",
        true,
        arrayOf(
            VideoAttachment(Video(123, 432, "Доспехи бога"))
        )
    )
    val post2 = Post(
        3,
        765,
        987,
        4123,
        765,
        "какойто текст2",
        false,
        Comment(6453, 12, 873, "true"),
        Reposts(10, true),
        "post",
        true,
        arrayOf(GraffitiAttachment(Graffiti(198, 875, "http")))
    )
    val com = Comment(972, 877, 893, "отличный пост")
    WallService.add(post1)
    WallService.add(post2)
    WallService.update(post1)
    WallService.createComment(45, com)
}
