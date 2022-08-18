package com.snapp.khabar.feature_fetch_news.domain.model

data class CommentModel (
    val name : String,
    val comment : String,
    val time : String,
    val imageUrl: String
)


fun getDummyComments() =
    listOf(
        CommentModel(
            "Edward Maya",
            "This is my life i'm chasing the dream that fade away in the night",
            "20 May 2022",
            "https://images.pexels.com/photos/39866/entrepreneur-startup-start-up-man-39866.jpeg"
        ),
        CommentModel(
            "Ed Sheeran",
            "Shape of you is the song composed and produced by me",
            "20 May 2022",
            "https://images.pexels.com/photos/2050979/pexels-photo-2050979.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        CommentModel(
            "Enrique Iglesias",
            "Why not me tell me why not me why not me tell me why not me, i wanna love you if you only knew how much i loved you so why not me",
            "20 May 2022",
            "https://images.pexels.com/photos/39866/entrepreneur-startup-start-up-man-39866.jpeg"
        ),
        CommentModel(
            "Akcent",
            "With eyes wide open, a new life opened i just realised it was no surprise, my heart is broken...",
            "20 May 2022",
            "https://images.pexels.com/photos/6940584/pexels-photo-6940584.jpeg?auto=compress&cs=tinysrgb&w=600"
        ),
        CommentModel(
            "Edward Maya",
            "This is my life i'm chasing the dream that fade away in the night",
            "20 May 2022",
            "https://images.pexels.com/photos/3831736/pexels-photo-3831736.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
        ),
        CommentModel(
            "Ed Sheeran",
            "Shape of you is the song composed and produced by me",
            "20 May 2022",
            "https://images.pexels.com/photos/2050979/pexels-photo-2050979.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        CommentModel(
            "Enrique Iglesias",
            "Why not me tell me why not me why not me tell me why not me, i wanna love you if you only knew how much i loved you so why not me",
            "20 May 2022",
            "https://images.pexels.com/photos/6940584/pexels-photo-6940584.jpeg?auto=compress&cs=tinysrgb&w=600"
        ),
        CommentModel(
            "Akcent",
            "With eyes wide open, a new life opened i just realised it was no surprise, my heart is broken...",
            "20 May 2022",
            "https://images.pexels.com/photos/3831736/pexels-photo-3831736.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
        )
    )