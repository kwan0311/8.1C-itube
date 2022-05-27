package com.example.itube_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button LoginButton, SignupButton;
    EditText Username_input, password_input;
    UserDatabaseHelper DB;
    public static final String USER_CODE="com.example.itube_app.USER_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginButton = findViewById(R.id.Login_button);
        SignupButton = findViewById(R.id.signup_button);
        Username_input = findViewById(R.id.Username);
        password_input = findViewById(R.id.Password);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user =Username_input.getText().toString();
                System.out.println(user);
                String userp =password_input.getText().toString();
                System.out.println(userp);
                if (TextUtils.isEmpty(user)||TextUtils.isEmpty(userp))
                {
                    Toast.makeText(MainActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }
                else{
                    DB = new UserDatabaseHelper(MainActivity.this);
                    boolean checkuserpass = DB.checkUser(user, userp);
                    if(checkuserpass == true)
                    {
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, Homepage.class);
                        intent.putExtra(USER_CODE, user);

                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SignUppage.class );
                startActivity(intent);

            }
        });

    }
}