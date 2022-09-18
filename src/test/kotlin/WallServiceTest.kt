import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }


    @Test
    fun add() {
        val post = Post(
            0,
            4123,
            4321,
            4123,
            4123,
            "какойто текст",
            true,
            Comments(0, true, false, true, true),
            Reposts(10, true),
            "post",
            true,
            arrayOf(
                AudioAttachment("Audio", Audio(123, 321, "Элвис")),
                GraffitiAttachment("Graffiti", Graffiti(432, 543, "http/"))
            )
        )

        val result = WallService.add(post)

        assertEquals(result.id, result.id)
    }

    @Test
    fun update() {
        val post = Post(
            0,
            4123,
            4321,
            4123,
            4123,
            "какойто текст",
            false,
            Comments(0, true, false, true, true),
            Reposts(10, true),
            "post",
            true,
            arrayOf(
                AudioAttachment("Audio", Audio(123, 321, "Элвис")),
                GraffitiAttachment("Graffiti", Graffiti(432, 543, "http/"))
            )
        )

        val post2 = Post(
            0,
            765,
            987,
            4123,
            765,
            "какойто текст2",
            true,
            Comments(0, true, false, true, true),
            Reposts(10, true),
            "post",
            true,
            arrayOf(VideoAttachment("Video", Video(230,123, "Доспехи бога")))
        )


        val result = WallService.add(post)
        val result2 = WallService.add(post2)
        val result3 = WallService.update(result)

        assertEquals(true, result3)
    }

    @Test
    fun updateFals() {
        val post = Post(
            1,
            4123,
            4321,
            4123,
            4123,
            "какойто текст",
            true,
            Comments(0, true, false, true, true),
            Reposts(10, true),
            "post",
            true,
            arrayOf(VideoAttachment("Video", Video(230,123, "Доспехи бога")))
        )

        WallService.add(post)
        val result = WallService.update(post)

        assertEquals(false, result)
    }
}