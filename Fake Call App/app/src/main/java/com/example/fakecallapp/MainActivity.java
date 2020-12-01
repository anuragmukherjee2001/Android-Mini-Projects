package com.example.fakecallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText phone_number = findViewById(R.id.number);
        Button call_button = findViewById(R.id.call_button);

        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent Call = new Intent(Intent.ACTION_CALL);
                String number = phone_number.getText().toString();

                if (number.trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT);
                }

                else {
                    Call.setData(Uri.parse("tel:" + number));
                }

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "Please Grant the permission", Toast.LENGTH_SHORT);
                    RequestPermision();
                }

                else{
                    startActivity(Call);
                }
            }
        });
    }

    private void RequestPermision(){

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }
}