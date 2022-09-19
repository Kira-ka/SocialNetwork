sealed class Attachment(val type: String)

data class VideoAttachment(val video: Video) : Attachment("Video")

data class AudioAttachment(val audio: Audio) : Attachment("Audio")

data class PhotoAttachment(val photo: Photo) : Attachment("Photo")

data class FileAttachment(val file: File) : Attachment("File")

data class GraffitiAttachment(val graffiti: Graffiti) : Attachment("Graffiti")

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

