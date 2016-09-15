package ayyash.app.seamolec_udj;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Muhamad Muslim Rifai on 9/15/2016.
 */
public class APIClient {
    public Context context;
    public SharedPreferences sp;
    SharedPreferences preferences = context.getSharedPreferences("", Activity.MODE_PRIVATE);

    public static final String BASE_URL = "";
    private static Retrofit retrofit = null;



    public static Retrofit getClient(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
