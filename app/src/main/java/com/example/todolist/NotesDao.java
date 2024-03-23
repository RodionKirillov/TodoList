package com.example.todolist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM notes")
    List<Note> getNotes();
    //    Single<List<Note>> getNotes();
    //    LiveData<List<Note>> getNotes();

    @Insert
    void add(Note note);
    //(onConflict = OnConflictStrategy.REPLACE) //добавление поведения при одинаковом id  у объекта
    //Completable add(Note note); // поддержка rxjjava

    @Query("DELETE FROM notes WHERE id = :id")
    void remove(int id);
    //Completable remove(int id);
}
