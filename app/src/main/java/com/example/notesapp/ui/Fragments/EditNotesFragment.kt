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
import androidx.navigation.fragment.navArgs
import com.example.notesapp.Model.Notes
import com.example.notesapp.R
import com.example.notesapp.ViewModel.NotesViewModel
import com.example.notesapp.databinding.FragmentEditNotesBinding
import java.util.*

class EditNotesFragment : Fragment() {

    val oldNotes by navArgs<EditNotesFragmentArgs>()
    var priority: String="1"
    lateinit var binding: FragmentEditNotesBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditNotesBinding.inflate(layoutInflater,container,false)

        binding.edtTitle.setText(oldNotes.data.title)
        binding.edtSubtitle.setText(oldNotes.data.subTitle)
        binding.edtNotes.setText(oldNotes.data.notes)

        when(oldNotes.data.priority){
            "1" -> {
                priority = "1"
                binding.pRed.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pOrange.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
            "2" -> {
                priority = "2"
                binding.pOrange.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pRed.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
            "3" -> {
                priority = "3"
                binding.pYellow.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pOrange.setImageResource(0)
                binding.pRed.setImageResource(0)
            }
        }

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

        binding.btnEditSaveNotes.setOnClickListener{
            updateNotes(it)
        }

        return binding.root
    }

    private fun updateNotes(it: View?) {

        val title = binding.edtTitle.text.toString()
        val subtitle = binding.edtSubtitle.text.toString()
        val notes = binding.edtNotes.text.toString()
        val date = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM, dd  yyyy",date.time)
        val data = Notes(
            oldNotes.data.id,
            title =title,
            subTitle = subtitle,
            notes = notes,
            date = notesDate.toString(),
            priority = priority
        )
        viewModel.updateNotes(data)

        Toast.makeText(requireContext(), "Notes Updated Successfully!!", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)

    }

}