package com.test.sampletest.util;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.test.sampletest.model.PopularArticles;

import java.util.List;

@Dao
public interface PopularArticlesDao {
    @Insert
    Long insertTask(PopularArticles popular_articles);

    @Query("SELECT * FROM popular_articles")
    MutableLiveData<List<PopularArticles>> fetchAllTasks();

    @Update
    void updateTask(PopularArticles popular_articles);


    @Delete
    void deleteTask(PopularArticles popular_articles);
}
