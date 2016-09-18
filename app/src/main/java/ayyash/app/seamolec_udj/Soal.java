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


    String opsiSoal[] = { "Pilihan A", "Pilihan B", "Pilihan C", "Pilihan D",
            "Pilihan d" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        tv = (TextView)findViewById(R.id.textView8);
        Intent i = getIntent();
         id_quiz = i.getIntExtra("kirimanIDQuiz", 0);
        tv.setText(""+id_quiz);


        LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.mLinearLayout);


        for (int k = 1; k <= 20; k++) {
            //create text button
            TextView tempatSoal = new TextView(this);
            tempatSoal.setText("Question Number:" + k);
            tempatSoal.setTextColor(Color.BLUE);
            mLinearLayout.addView(tempatSoal);
            // create radio button
            final RadioButton[] rb = new RadioButton[5];
            RadioGroup rg = new RadioGroup(this);
            rg.setOrientation(RadioGroup.VERTICAL);
            for (int i1= 0; i1 < 5; i1++) {
                rb[i1] = new RadioButton(this);
                rg.addView(rb[i1]);
                rb[i1].setText(opsiSoal[i1]);

            }
            mLinearLayout.addView(rg);
        }




    }
}
