package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    private ToggleButton mode;
    private Button convert;
    private TextView result;
    private EditText enterTemp;
    private LinearLayout historylayout;
    double result0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mode = findViewById(R.id.mode);
        convert=findViewById(R.id.convert);
        enterTemp=findViewById(R.id.enterTemp);
        result=findViewById(R.id.result);
        historylayout=findViewById(R.id.historylayout);



        convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(enterTemp.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter the temperature",Toast.LENGTH_SHORT).show();
                }

                else if(mode.isChecked())
                {
                    double temp = Double.parseDouble(enterTemp.getText().toString());
                    result0=(temp*1.8)+32;
                    result.setText(String.valueOf((result0)));
                    TextView historytext=new TextView(getBaseContext());
                    historytext.setText("Converted C: "+String.valueOf(temp)+" TO F: "+String.valueOf(result0));
                    historylayout.addView(historytext);
                }

                else
                {
                    double temp = Double.parseDouble(enterTemp.getText().toString());
                    result0=(temp-32)/1.8;
                    result.setText(String.valueOf((result0)));
                    TextView historytext=new TextView(getBaseContext());
                    historytext.setText("Converted F: "+String.valueOf(temp)+" TO C: "+String.valueOf(result0));
                    historylayout.addView(historytext);
                }}});
    }
}