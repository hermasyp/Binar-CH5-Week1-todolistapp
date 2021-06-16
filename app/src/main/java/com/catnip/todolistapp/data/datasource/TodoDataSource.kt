package com.catnip.todolistapp.data.datasource

import com.catnip.todolistapp.data.model.Todo

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class TodoDataSource {
    private var todos = mutableListOf<Todo>().apply {
        add(
            Todo(
                1,
                "Mencuci baju",
                "Harus mencuci baju orang serumah",
                "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg",
                true
            )
        )
        add(
            Todo(
                2,
                "Ngoding",
                "Belajar Kotlin dengan binarian",
                "https://teknojurnal.com/wp-content/uploads/2017/05/Kotlin-1280x720.png",
                false
            )
        )
        add(
            Todo(
                3,
                "Ngopi bareng temen",
                "Ngopi sama temen temen kuliah di margonda",
                "https://cdns.klimg.com/dream.co.id/resized/640x320/news/2018/09/06/92004/664xauto-wanita-tanpa-mahram-dilarang-ngopi-sampai-larut-malam-di-bireuen-1809064.jpg",
                true
            )
        )
        add(
            Todo(
                4,
                "Kerjain project binar",
                "kerjain project binar di rumah",
                "https://3.bp.blogspot.com/-l4LeiiwW9oo/VriYhCuLp1I/AAAAAAAADWk/R2XkYdnH-_s/s1600/skill-koding-jungjawa-blog.jpg",
                false
            )
        )
        add(
            Todo(
                5,
                "Kerjain project kantor",
                "kerjain project binar di rumah nih gak ngapa ngapain mendingan ngoding",
                "https://3.bp.blogspot.com/-l4LeiiwW9oo/VriYhCuLp1I/AAAAAAAADWk/R2XkYdnH-_s/s1600/skill-koding-jungjawa-blog.jpg",
                true
            )
        )
    }

    fun changeTodoStatus(targetId : Int){
        todos.first { it.id == targetId }.apply {
            isTaskCompleted = isTaskCompleted.not()
        }
    }

    fun getTodosByStatus(isTaskCompleted : Boolean) : List<Todo>{
        return todos.filter { it.isTaskCompleted == isTaskCompleted }
    }

}