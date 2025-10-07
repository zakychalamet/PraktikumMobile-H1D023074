package com.unsoed.informatikamobile.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pemmob1.R
import com.example.pemmob1.databinding.FragmentBookDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A simple [Fragment] subclass.
 * Use the [BookDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookDetailFragment (
    private val title: String,
    private val author: String,
    private val year: String,
    private val coverUrl: Int
) : BottomSheetDialogFragment () {

    private var _binding: FragmentBookDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        Toast.makeText(context, "$coverUrl", Toast.LENGTH_SHORT).show()
        binding.textViewTitle.text = title
        binding.textViewAuthor.text = author
        binding.textViewYear.text = year

        if (coverUrl != 0) {
            val url = "https://covers.openlibrary.org/b/id/${coverUrl}-M.jpg"
            Glide.with(this)
                .load(url)
                .into(binding.imageViewCover)
        } else {
            binding.imageViewCover.setImageResource(
                R.drawable.ic_book
            )
        }
    }
}