package com.example.user.kelompok1_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpen = (Button) findViewById(R.id.btnOpen);
        //set OnClickListener event to btnOpen
        btnOpen.setOnClickListener(new View.OnClickListener(){
            public void OnClick(View v){
                callIntent();
            }
        });
    }

    public void callIntent(){
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        EditText text1 = (EditText) findViewById(R.id.editText1);
        String dataactivity_1 = text1.getText().toString();
        //untuk mengirim data gunakan putExtra
        i.putExtra("value1", dataactivity_1);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("return_value1")) {
                EditText text2 = (EditText) findViewById(R.id.editTextdr2);
                text2.setText(data.getExtras().getString("return_value1"));
            }
        }
    }
}
