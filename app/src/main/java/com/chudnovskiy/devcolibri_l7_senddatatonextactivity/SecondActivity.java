package com.chudnovskiy.devcolibri_l7_senddatatonextactivity;

import android.app.appsearch.GetByDocumentIdRequest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    static final String MESSAGE = "message";

    private TextView login;
    private TextView password;
    private EditText editTextMessage;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();

        initViews();
        fillTextViewsFields();

        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                if (!editTextMessage.getText().toString().isEmpty()) {
                    intent.putExtra(MESSAGE, editTextMessage.getText().toString());
                }
                startActivity(intent);
            }
        });
    }

    private void fillTextViewsFields() {
        String login = getIntent().getStringExtra(MainActivity.LOGIN);
        this.login.setText(getResources().getString(R.string.login) + " " + login);

        String password = getIntent().getStringExtra(MainActivity.PASS);
        this.password.setText(getResources().getText(R.string.password) + " " + password);
    }

    private void initViews() {
        login = (TextView) findViewById(R.id.text_view_login);
        password = (TextView) findViewById(R.id.text_view_pass);
        editTextMessage = (EditText) findViewById(R.id.edit_text_from_second_activity);
        btnBack = (Button) findViewById(R.id.button_back);
    }
}