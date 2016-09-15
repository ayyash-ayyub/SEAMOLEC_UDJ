package ayyash.app.seamolec_udj;

import android.app.ProgressDialog;
import android.content.Intent;
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


/**
 * Created by Ayyash on 9/15/2016.
 */
public class Register extends AppCompatActivity {


    EditText nis,password,nama,id_kelas;
    Button btnRegister,btnAmbil;
    private ProgressDialog pDialog;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        nis = (EditText)findViewById(R.id.nis);
        password = (EditText)findViewById(R.id.password);
        nama = (EditText)findViewById(R.id.nama);
        id_kelas = (EditText)findViewById(R.id.id_kelas);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        tv = (TextView)findViewById(R.id.textView4);
        btnAmbil = (Button)findViewById(R.id.btnAmbil);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"Simpan", Toast.LENGTH_SHORT).show();
                setSiswaDetails();

            }
        });

        btnAmbil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showpDialog();


                try {

                    Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();



                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://192.168.50.132/new_udj/ngecek.php/").
                                    addConverterFactory(GsonConverterFactory.create(gson))
                            .build();

                    APIService service = retrofit.create(APIService.class);

                    Call<List<DataSiswa>> call = service.getSiswaDetails();

                    call.enqueue(new Callback<List<DataSiswa>>() {
                        @Override
                        public void onResponse(Call<List<DataSiswa>> call, Response<List<DataSiswa>> response) {
                            List<DataSiswa> peopleData = response.body();
                            String details = "";
                            for (int i = 0; i < peopleData.size(); i++) {
                                String nis = peopleData.get(i).getNis();


                                details += "nis: " + nis + "\n" +
                                        "pass: " + password + "\n\n";


                            }
                            Toast.makeText(Register.this, details, Toast.LENGTH_SHORT).show();
                           tv.setText(details);
                            hidepDialog();

                        }

                        @Override
                        public void onFailure(Call<List<DataSiswa>> call, Throwable t) {
                            Log.d("onFailure", t.toString());
                            hidepDialog();
                        }
                    });

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                    hidepDialog();
                }





            }
        });

    }





    DataSiswa ds;

    private void setSiswaDetails() {
        showpDialog();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.50.37/").
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
