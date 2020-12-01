package com.example.registrationdataextraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){
        TextView FirstNameView = findViewById(R.id.view_first_name);
        TextView LastNameView = findViewById(R.id.view_last_name);
        TextView EmailView = findViewById(R.id.view_email);

        EditText editFirstName = findViewById(R.id.FirstName);
        EditText editlastName = findViewById(R.id.LastName);
        EditText editemail = findViewById(R.id.Email);

        FirstNameView.setText("First Name: " + editFirstName.getText().toString());
        LastNameView.setText("Last Name: " + editlastName.getText().toString());
        EmailView.setText("Email: " + editemail.getText().toString());
    }
}