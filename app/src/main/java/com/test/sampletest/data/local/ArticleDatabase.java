package com.test.sampletest.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.test.sampletest.data.local.dao.ArticleDao;
import com.test.sampletest.data.local.entity.ArticleEntity;

@Database(entities = {ArticleEntity.class}, version = 2)
public abstract class ArticleDatabase extends RoomDatabase {
    public abstract ArticleDao articleDao();
}