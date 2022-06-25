package com.example.notesapp.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.notesapp.Model.Notes
import com.example.notesapp.R
import com.example.notesapp.ViewModel.NotesViewModel
import com.example.notesapp.databinding.FragmentCreateNotesBinding
import java.util.*

class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentCreateNotesBinding
    var priority: String="1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNotesBinding.inflate(layoutInflater,container,false)
        binding.pRed.setImageResource(R.drawable.ic_baseline_done_24)

        binding.pRed.setOnClickListener{
            binding.pRed.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pOrange.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.pOrange.setOnClickListener{
            priority ="2"
            binding.pOrange.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.pYellow.setOnClickListener{
            priority = "3"
            binding.pYellow.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pOrange.setImageResource(0)
            binding.pRed.setImageResource(0)
        }

        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }

        return binding.root
    }

    private fun createNotes(it: View?){
        val title = binding.edtTitle.text.toString()
        val subtitle = binding.edtSubtitle.text.toString()
        val notes = binding.edtNotes.text.toString()
        val date = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM, dd  yyyy",date.time)
        val data = Notes(
            id = null,
            title =title,
            subTitle = subtitle,
            notes = notes,
            date = notesDate.toString(),
            priority = priority
        )
        viewModel.addNotes(data)

        Toast.makeText(requireContext(), "Notes Created Successfully!!", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
    }

}