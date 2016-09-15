/*
 * Created by Shaon on 8/15/16 8:06 PM
 * Copyright (c) 2016. This is free to use in any software.
 * You must provide developer name on your project.
 */

package ayyash.app.seamolec_udj;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by Ayyash on 9/14/2016.
 */
public interface APIService {
    @GET("http://192.168.50.132/new_udj/ngecek.php/")
    Call<List<DataSiswa>>getSiswaDetails();

    @FormUrlEncoded
    @POST("http://192.168.50.132/new_udj/insert.php/")
   Call<DataSiswa> setDataSiswaDetails(@Field("nis") String nis,@Field("password") String password, @Field("nama") String nama,  @Field("id_kelas") int id_kelas );



//    @FormUrlEncoded
//    @POST("http://192.168.50.132/new_udj/insert.php")
//    void postData(@Field("nis") String nis,
//                  @Field("password") String password,
//                  @Field("nama") String nama,
//                  Call<DataSiswa> setDataSiswaDetails);
}



