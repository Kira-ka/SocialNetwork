interface Attachment {
    val typeStr: String
}

interface Type {
    val id: Int
    val ownerId: Int
}

data class  Audio(override val id: Int, override val ownerId: Int, val artist: String) : Type{
}
data class  Video(override val id: Int, override val ownerId: Int, val title: String) : Type{
}
data class  Photo(override val id: Int, override val ownerId: Int, val albumId: Int) : Type{
}
data class File(override val id: Int, override val ownerId: Int, val title: String) : Type{
}
data class Graffiti(override val id: Int, override val ownerId: Int, val url: String) : Type{
}

class AudioAttachment(override val typeStr: String, val type: Audio) : Attachment {
}
class VideoAttachment(override val typeStr: String, val type: Video) : Attachment {
}
class PhotoAttachment(override val typeStr: String, val type: Photo) : Attachment {
}
class FileAttachment(override val typeStr: String, val type: File) : Attachment {
}
class GraffitiAttachment(override val typeStr: String, val type: Graffiti) : Attachment {
}