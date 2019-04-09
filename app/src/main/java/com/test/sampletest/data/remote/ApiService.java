package com.test.sampletest.data.remote;

import com.test.sampletest.data.remote.model.PopularArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    //@GET("svc/mostpopular/v2/mostviewed/all-sections/{index}.json")

    //https://api.nytimes.com/svc/mostpopular/v2/emailed/7.json?api-key=b190Hijkb6kGQlqVFQCkhQIMiGT0iXjS
    @GET("svc/mostpopular/v2/emailed/{index}.json")
    Call<PopularArticleResponse> loadPopularArticles(@Path("index") int index);
}
