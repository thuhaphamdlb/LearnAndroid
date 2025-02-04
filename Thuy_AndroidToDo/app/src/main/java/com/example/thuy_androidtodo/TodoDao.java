package com.example.thuy_androidtodo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo")
    List<Todo> getAll();


    @Insert
    void insert(Todo... todo);

    @Delete
    void delete(Todo todo);
}