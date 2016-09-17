package ayyash.app.seamolec_udj;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Abdul Rizal Adompo on 9/17/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final Context context;

    List<GetDataAdapterSiswa> getDataAdapter;
    Button btnTampan;



    public RecyclerViewAdapter(List<GetDataAdapterSiswa> getDataAdapter, Context context){

        super();

        this.getDataAdapter = getDataAdapter;
        this.context = context;




    }







    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }
    GetDataAdapterSiswa getDataAdapter1;
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       getDataAdapter1 =  getDataAdapter.get(position);

        holder.tampilIDSiswa.setText(String.valueOf(getDataAdapter1.getId_siswa()).toString());

        holder.tampilNis.setText(String.valueOf(getDataAdapter1.getNis()).toString());

        holder.tampilNama.setText(getDataAdapter1.getNama());

        holder.tampilIdKelas.setText(String.valueOf(getDataAdapter1.getIdKelas()).toString());

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();

    }







    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tampilIDSiswa;
        public TextView tampilNis;
        public TextView tampilNama;
        public TextView tampilIdKelas;



        public ViewHolder(View itemView) {

            super(itemView);


            tampilIDSiswa = (TextView) itemView.findViewById(R.id.tampil_ID_siswa) ;
            tampilNis = (TextView) itemView.findViewById(R.id.tampilNis) ;
            tampilNama = (TextView) itemView.findViewById(R.id.tampilNama) ;
            tampilIdKelas = (TextView) itemView.findViewById(R.id.tampilIDKelas) ;



            btnTampan = (Button)itemView.findViewById(R.id.btnPengantarKeQuiz);



            btnTampan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Uye", "BAYAR");
//                    Intent i = new Intent(context, Lemparan.class);
//                        context.startActivity(i);
//                       ((MainActivity)context).finish();

                }
            });




        }
    }
}
