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
            "какойто текст",
            true,
            Comments(0, true, false, true, true),
            Reposts(10, true),
            "post",
            true)

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
            "какойто текст",
            true,
            Comments(0, true, false, true, true),
            Reposts(10, true),
            "post",
            true)

        val result = WallService.add(post)
        val result2 = WallService.update(result)

        assertEquals(true, result2)
    }

    @Test
    fun updateFals() {
        val post = Post(
            0,
            4123,
            4321,
            4123,
            "какойто текст",
            true,
            Comments(0, true, false, true, true),
            Reposts(10, true),
            "post",
            true)

        WallService.add(post)
        val result = WallService.update(post)

        assertEquals(false, result)
    }
}