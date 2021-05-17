package sg.edu.rp.c346.id20007998.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView phone;
    TextView ppl;
    TimePicker tp;
    DatePicker dp;
    CheckBox smoke;
    Button confirm;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.inputName);
        phone=findViewById(R.id.inputPhone);
        ppl=findViewById(R.id.inputPpl);
        tp=findViewById(R.id.timePick);
        dp=findViewById(R.id.datePick);
        smoke=findViewById(R.id.checkBoxSmoke);
        confirm=findViewById(R.id.btnCon);
        reset=findViewById(R.id.btnRe);

        tp.setCurrentMinute(30);
        tp.setCurrentHour(19);
        dp.updateDate(2020,5,1);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().trim().length()!=0 && phone.getText().toString().trim().length()!=0 && ppl.getText().toString().trim().length()!=0){
                    String message="Thank you ";
                    message+=name.getText();
                    message+=", please confirm your information. Number: ";
                    message+=phone.getText();
                    message+=" and you reservate a table for ";
                    message+=ppl.getText()+" people in ";
                    if (smoke.isChecked()){
                        message+="smoking area on ";
                    }else{
                        message+="non-smoking area on";
                    }
                    message+=dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear()+" "+tp.getCurrentHour()+":"+tp.getCurrentMinute()+" !";

                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Please fill up all information!",Toast.LENGTH_SHORT).show();
                }


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentMinute(30);
                tp.setCurrentHour(19);
                dp.updateDate(2020,5,1);
                smoke.setChecked(false);
                name.setText("");
                phone.setText("");
                ppl.setText("");


            }
        });






    }
}