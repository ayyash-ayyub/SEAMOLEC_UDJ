package ayyash.app.seamolec_udj;

import javax.xml.transform.Result;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ayyash on 9/15/2016.
 */
public interface RetrofitAPIEndpointInterface {

    @GET("api")
    Call<Result> getResultInfo();

    @GET("api")
    Call<ResponseBody> getResultAsJSON();
}
