package com.example.pemmob1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pemmob1.databinding.ActivityDaftarBukuBinding
import com.unsoed.informatikamobile.data.model.BookDoc
import com.unsoed.informatikamobile.ui.adapter.BookAdapter
import com.unsoed.informatikamobile.ui.adapter.OnBookClickListener
import com.unsoed.informatikamobile.ui.fragment.BookDetailFragment
import com.unsoed.informatikamobile.viewmodel.MainViewModel

class DaftarBukuActivity : AppCompatActivity(), OnBookClickListener {
	private lateinit var binding: ActivityDaftarBukuBinding
	private val viewModel: MainViewModel by viewModels()
	private val adapter = BookAdapter(emptyList(), this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.recyclerView.layoutManager = LinearLayoutManager(this)
		binding.recyclerView.adapter = adapter

		viewModel.books.observe(this) {
			adapter.setData(it)
		}

		viewModel.fetchBooks("kotlin programming")
	}

	override fun onBookClick(book: BookDoc) {
		book.let { b->
			BookDetailFragment(
				b.title?:"-",
				b.authorName?.joinToString(", ") ?: "-",
				b.firstPublishYear?.toString() ?: "-",
				b.coverId ?: 0
			).show(supportFragmentManager, BookDetailFragment::class.java.simpleName)
		}
	}
}
