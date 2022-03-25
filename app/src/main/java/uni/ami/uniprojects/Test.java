package uni.ami.uniprojects;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity implements View.OnClickListener {

    Button transferData;
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        transferData = findViewById(R.id.transferData);
        transferData.setOnClickListener(this);

        userNameEditText = findViewById(R.id.userNameEditText);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Task7AddidionTask3TransferName.class);
        intent.putExtra("name", userNameEditText.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.task7_my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getTitle().toString()) {
            case "activity1":
                intent = new Intent(this, Task7Activity2.class);
                break;
            case "activity2":
                intent = new Intent(this, Task7Activity3.class);
                Log.d("LOOK HERE", item.getTitle().toString());
                break;
            case "activity3":
                intent = new Intent(this, Task7Activity4.class);
                Log.d("LOOK HERE", item.getTitle().toString());
                break;
            case "activity4":
                intent = new Intent(this, Task7Activity5.class);
                Log.d("LOOK HERE", item.getTitle().toString());
                break;
            default:
                intent = new Intent(this, Test.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

}