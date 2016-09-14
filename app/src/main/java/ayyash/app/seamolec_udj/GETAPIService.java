/*
 * Created by Shaon on 8/14/16 10:42 PM
 * Copyright (c) 2016. This is free to use in any software.
 * You must provide developer name on your project.
 */

package ayyash.app.seamolec_udj;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by  8/14/2016.
 */
public interface GETAPIService {

    @GET("my_json")
    Call<List<DataSiswa>> getDataSiswaDetails();
}
