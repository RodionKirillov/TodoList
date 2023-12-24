package com.example.todolist;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM notes")
    List<Note> getNotes();

    @Insert
        //(onConflict = OnConflictStrategy.REPLACE) //добавление поведения при одинаковом id  у объекта
    void add(Note note);

    @Query("DELETE FROM notes WHERE id = :id")
    void remove(int id);
}
