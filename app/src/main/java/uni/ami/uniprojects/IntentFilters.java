package uni.ami.uniprojects;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IntentFilters extends AppCompatActivity  implements View.OnClickListener {

    Button btnTime, btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filters);
        btnTime = findViewById(R.id.btnTime);
        btnDate = findViewById(R.id.btnDate);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
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
        }
    }
}