package com.test.sampletest.util;

import android.arch.persistence.room.Database;

import com.test.sampletest.model.PopularArticles;

@Database(entities = {PopularArticles.class}, version = 1, exportSchema = false)
public abstract class PopularArticlesDatabase {
    public abstract PopularArticlesDao popularArticlesDao();
}
