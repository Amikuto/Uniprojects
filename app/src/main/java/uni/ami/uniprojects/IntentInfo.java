package uni.ami.uniprojects;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IntentInfo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_info);

        // получаем Intent, который вызывал это Activity
        Intent intent = getIntent();
        // читаем из него action
        String action = intent.getAction();

        String format = "", textInfo = "";

        // в зависимости от action заполняем переменные
        if (action.equals("uni.ami.intent.action.showtime")) {
            format = "HH:mm:ss";
            textInfo = "Time: ";
        }
        else if (action.equals("uni.ami.intent.action.showdate")) {
            format = "dd.MM.yyyy";
            textInfo = "Date: ";
        }

        // в зависимости от содержимого переменной format
        // получаем дату или время в переменную datetime
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String datetime = sdf.format(new Date(System.currentTimeMillis()));

        TextView tvDate = findViewById(R.id.tvInfo);
        tvDate.setText(textInfo + datetime);
    }
}