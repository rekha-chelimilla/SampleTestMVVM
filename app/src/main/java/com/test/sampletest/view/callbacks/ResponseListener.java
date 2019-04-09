package com.test.sampletest.view.callbacks;

import com.test.sampletest.data.local.entity.ArticleEntity;

public interface ResponseListener {

    void onSuccess(ArticleEntity data);
    void onFailure(String message);
}
