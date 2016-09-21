package ayyash.app.seamolec_udj;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Soal extends AppCompatActivity {

    TextView tv;
    int id_quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        tv = (TextView)findViewById(R.id.textView8);
        Intent i = getIntent();
         id_quiz = i.getIntExtra("kirimanIDQuiz", 0);
        tv.setText(""+id_quiz);

        LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.mLinearLayout);

        String [] Soal = {"Berapa?", "Siapa?", "Kapan?", "Dimana?"};
        String[][] opsiSoal={
                {"1", "2", "3"} ,
                { "saya", "kamu", "dia", "mereka", "kita"},
                {"sekarang", "waktu itu"},
                {"disini", "disana"}
        } ;

//        int jml_soal = opsiSoal.length - 1;
//        for (int x =0; x<Soal.length; x++){
//            System.out.println("soal "+ Soal[x]);
//            for (int y=0; y < opsiSoal[x].length; y++){
//                System.out.println(opsiSoal[x][y]);
//            }
//        }

        for (int k = 0; k < Soal.length; k++) {
            //create text button

            TextView tempatSoal = new TextView(this);
            tempatSoal.setText(Soal[k]);
            tempatSoal.setTextColor(Color.BLUE);
            mLinearLayout.addView(tempatSoal);
            // create radio button
            final RadioButton[] rb = new RadioButton[6];
            RadioGroup rg = new RadioGroup(this);
            rg.setOrientation(RadioGroup.VERTICAL);
                for (int l=0; l<opsiSoal[k].length; l++ ){
                    rb[l] = new RadioButton(this);
                    rg.addView(rb[l]);
                    rb[l].setText(opsiSoal[k][l]);
                }

            mLinearLayout.addView(rg);
        }
    }
}
