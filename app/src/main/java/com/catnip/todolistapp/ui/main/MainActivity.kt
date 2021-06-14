package com.catnip.todolistapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.catnip.todolistapp.data.constant.Constant
import com.catnip.todolistapp.data.model.Todo
import com.catnip.todolistapp.databinding.ActivityMainBinding
import com.catnip.todolistapp.ui.detail.DetailTaskActivity
import com.catnip.todolistapp.ui.main.adapter.TodoAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initList()
    }

    private fun initList() {
        todoAdapter = TodoAdapter {
            val intent = Intent(this,DetailTaskActivity::class.java)
            intent.putExtra(Constant.EXTRAS_TODO_DATA,it)
            startActivity(intent)
        }
        binding.rvTask.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = todoAdapter
        }
        todoAdapter.items = generateDummyData()
    }

    private fun generateDummyData(): List<Todo> {
        return mutableListOf<Todo>().apply {
            add(
                Todo(
                    "Mencuci baju",
                    "Harus mencuci baju orang serumah",
                    "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg"
                )
            )
            add(
                Todo(
                    "Working Project : Binar",
                    "Membuat Project Challenge Binar CH 5",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 2",
                    "Membuat Project Challenge Binar CH 5 - 1",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 3",
                    "Membuat Project Challenge Binar CH 5 - 2",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 4",
                    "Membuat Project Challenge Binar CH 5 - 3",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Mencuci baju 2",
                    "Harus mencuci baju orang serumah",
                    "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg"
                )
            )
            add(
                Todo(
                    "Working Project : Binar 2",
                    "Membuat Project Challenge Binar CH 5",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 22",
                    "Membuat Project Challenge Binar CH 5 - 1",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 33",
                    "Membuat Project Challenge Binar CH 5 - 2",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 44",
                    "Membuat Project Challenge Binar CH 5 - 3",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Mencuci baju 5",
                    "Harus mencuci baju orang serumah",
                    "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg"
                )
            )
            add(
                Todo(
                    "Working Project : Binar 6",
                    "Membuat Project Challenge Binar CH 5",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 27",
                    "Membuat Project Challenge Binar CH 5 - 1",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 38",
                    "Membuat Project Challenge Binar CH 5 - 2",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 49",
                    "Membuat Project Challenge Binar CH 5 - 3",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Mencuci baju 9",
                    "Harus mencuci baju orang serumah",
                    "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg"
                )
            )
            add(
                Todo(
                    "Working Project : Binar 9",
                    "Membuat Project Challenge Binar CH 5",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 236",
                    "Membuat Project Challenge Binar CH 5 - 1",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 3362",
                    "Membuat Project Challenge Binar CH 5 - 2",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
            add(
                Todo(
                    "Working Project : Binar 42356",
                    "Membuat Project Challenge Binar CH 5 - 3",
                    "https://media.istockphoto.com/vectors/origamisign2orange-vector-id1165147642?b=1&k=6&m=1165147642&s=612x612&w=0&h=gRulyoRq8aKs8GtetjLJHMyJ_4btD-V5zotQ1_ivvHE="
                )
            )
        }
    }
}