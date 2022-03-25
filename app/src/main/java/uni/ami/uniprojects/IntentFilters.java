package uni.ami.uniprojects;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentFilters extends AppCompatActivity  implements View.OnClickListener {

    Button btnTime, btnDate, btnLastName, goToURL, openSettings, takePhoto;
    EditText etLName, webURL;
    TextView textViewLName;
    ImageView imageView;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filters);
        btnTime = findViewById(R.id.btnTime);
        btnDate = findViewById(R.id.btnDate);
        btnLastName = findViewById(R.id.btnLastName);
        goToURL = findViewById(R.id.goToURL);
        openSettings = findViewById(R.id.openSettings);
        takePhoto = findViewById(R.id.takePhoto);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
        btnLastName.setOnClickListener(this);
        goToURL.setOnClickListener(this);
        openSettings.setOnClickListener(this);
        takePhoto.setOnClickListener(this);

        etLName = findViewById(R.id.etLName);
        webURL = findViewById(R.id.webURL);

        textViewLName = findViewById(R.id.textViewLName);
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
            case R.id.webURL:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webURL.getText().toString()));
                startActivity(intent);
                break;
            case R.id.openSettings:
                intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case R.id.takePhoto:
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                } catch (ActivityNotFoundException e) {
                    // display error state to the user
                    System.out.println(e);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == 1) {
            String name = data.getStringExtra("name");
            textViewLName.setText("Your last name is " + name);
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}