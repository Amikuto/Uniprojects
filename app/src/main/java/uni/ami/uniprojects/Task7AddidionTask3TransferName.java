package uni.ami.uniprojects;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Task7AddidionTask3TransferName extends AppCompatActivity {
    TextView givenUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task7_addidion_task3_transfer_name);
        givenUserName = findViewById(R.id.givenUserName);
        Intent intent = getIntent();

        String fName = intent.getStringExtra("name");
        givenUserName.setText(fName);
    }
}