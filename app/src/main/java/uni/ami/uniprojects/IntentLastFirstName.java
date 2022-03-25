package uni.ami.uniprojects;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentLastFirstName extends AppCompatActivity implements View.OnClickListener {
    EditText lastName;
    Button btnOK;
    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_last_first_name);

        tvView = findViewById(R.id.tvView);
        Intent intent = getIntent();

        String fName = intent.getStringExtra("fname");
        tvView.setText("Your first name is: " + fName);

        lastName = findViewById(R.id.lastName);
        btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", lastName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}