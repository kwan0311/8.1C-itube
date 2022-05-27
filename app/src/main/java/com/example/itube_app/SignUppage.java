package com.example.itube_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUppage extends AppCompatActivity {
    Button CreateButton;
    EditText fullname, username, password, confirmedpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_uppage);
        CreateButton = findViewById(R.id.Create_Account_button);
        fullname = findViewById(R.id.Signupfullname);
        username = findViewById(R.id.SignupuserName);
        password = findViewById(R.id.Signuppassword);
        confirmedpass = findViewById(R.id.SignupConfirm);

        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(confirmedpass.getText().toString().equals(password.getText().toString() )) {
                    UserDatabaseHelper dbuser = new UserDatabaseHelper(SignUppage.this);
                    dbuser.add_User(fullname.getText().toString().trim(),
                            username.getText().toString().trim(),
                            password.getText().toString().trim());

                }
                else
                {
                    Toast.makeText(SignUppage.this, "The confirmed and password is not the same! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}