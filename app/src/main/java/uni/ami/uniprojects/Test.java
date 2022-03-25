package uni.ami.uniprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
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