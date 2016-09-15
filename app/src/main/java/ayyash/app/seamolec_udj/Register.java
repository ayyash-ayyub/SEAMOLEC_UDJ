package ayyash.app.seamolec_udj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by Ayyash on 9/15/2016.
 */
public class Register extends AppCompatActivity {


    EditText nis,password,nama,id_kelas;
    Button btnRegister,btnAmbil;
    private ProgressDialog pDialog;
    TextView tv;
    private String ambilIP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        nis = (EditText)findViewById(R.id.nis);
        password = (EditText)findViewById(R.id.password);
        nama = (EditText)findViewById(R.id.nama);
        id_kelas = (EditText)findViewById(R.id.id_kelas);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);


        //ngambil IP
        SharedPreferences sps = getSharedPreferences("", MODE_PRIVATE);
        ambilIP = sps.getString("IPnya", "");

        Toast.makeText(Register.this, "IP Server: " + ambilIP, Toast.LENGTH_LONG).show();



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"Simpan", Toast.LENGTH_SHORT).show();
                setSiswaDetails();

            }
        });



    }





    DataSiswa ds;

    private void setSiswaDetails() {
        showpDialog();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ambilIP+"/").
                        addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
         ds = new DataSiswa();

        ds.setNis(nis.getText().toString());
        ds.setPassword(password.getText().toString());
        ds.setNama(nama.getText().toString());

        int ayyash1 = Integer.parseInt(id_kelas.getText().toString());
        ds.setId_kelas(ayyash1);


        final Call<DataSiswa> simpanSiswa = service.setDataSiswaDetails(ds.getNis(),ds.getPassword(), ds.getNama(),ds.getId_kelas());



                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
                finish();


        Log.d("uye","uye" +simpanSiswa);


        simpanSiswa.enqueue(new Callback<DataSiswa>() {
            @Override
            public void onResponse(Call<DataSiswa> call, Response<DataSiswa> response) {
                hidepDialog();

//                if(call.isExecuted()==true && ds.getNis().toString()!=null){
//                    Toast.makeText(getApplicationContext(),"Data Tersimpan", Toast.LENGTH_SHORT).show();
//                }




            }
            @Override
            public void onFailure(Call<DataSiswa> call, Throwable t) {
                hidepDialog();



            }
        });



    }



    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


}
