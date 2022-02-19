package com.chudnovskiy.devcolibri_l7_senddatatonextactivity;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    static final String PASS = "pass";
    static final String LOGIN = "login";

    private EditText login;
    private EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        initViews();
        getMessageFromSecondActivity();

        button.setOnClickListener(view -> goToSecondActivity());
        //TODO: необходимо сделать функционал сохранения данных пре повороте устройства
    }

    private void initViews() {
        login = (EditText) findViewById(R.id.edit_text_login);
        password = (EditText) findViewById(R.id.edit_text_password);
        button = (Button) findViewById(R.id.button);
    }

    private void getMessageFromSecondActivity() {
        if (getIntent().hasExtra(SecondActivity.MESSAGE)) {
            final String stringExtra = getIntent().getStringExtra(SecondActivity.MESSAGE);
            if (!stringExtra.isEmpty())
                toastShow(stringExtra);
        }
    }

    private void goToSecondActivity() {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        if (!login.getText().toString().isEmpty()
                && !password.getText().toString().isEmpty()) {
            intent.putExtra(LOGIN, login.getText().toString());
            intent.putExtra(PASS, password.getText().toString());

            startActivity(intent);
        } else {
            toastShow("Empty Login or Password fields");
        }
    }

    private void toastShow(String message) {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                message,
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}