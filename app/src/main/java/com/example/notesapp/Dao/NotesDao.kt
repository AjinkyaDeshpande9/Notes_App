package com.example.notesapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesapp.Model.Notes

@Dao
interface NotesDao{

    @Query("SELECT * FROM Notes")
    fun getNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("DELETE FROM Notes WHERE id=:id")
    fun deleteNotes(id: Int)

    @Update
    fun updateNotes(notes: Notes)

}