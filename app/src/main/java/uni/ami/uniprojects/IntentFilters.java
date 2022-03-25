package uni.ami.uniprojects;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentFilters extends AppCompatActivity  implements View.OnClickListener {

    Button btnTime, btnDate, btnLastName;
    EditText etLName;
    TextView textViewLName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filters);
        btnTime = findViewById(R.id.btnTime);
        btnDate = findViewById(R.id.btnDate);
        btnLastName = findViewById(R.id.btnLastName);

        textViewLName = findViewById(R.id.textViewLName);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
        btnLastName.setOnClickListener(this);

        etLName = findViewById(R.id.etLName);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent;

        switch(view.getId()) {
            case R.id.btnTime:
//                intent = new Intent(IntentFilters.this, IntentTime.class);
                intent = new Intent("uni.ami.intent.action.showtime");
                startActivity(intent);
                break;
            case R.id.btnDate:
//                intent = new Intent(IntentFilters.this, IntentDate.class);
                intent = new Intent("uni.ami.intent.action.showdate");
                startActivity(intent);
                break;
            case R.id.btnLastName:
                intent = new Intent(this, IntentLastFirstName.class);
                intent.putExtra("fname", etLName.getText().toString());
                startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String name = data.getStringExtra("name");
        textViewLName.setText("Your last name is " + name);
    }
}