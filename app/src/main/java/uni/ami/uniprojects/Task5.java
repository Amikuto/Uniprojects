package uni.ami.uniprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Task5 extends AppCompatActivity {
    TextView tv;
    CheckBox chb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);
        // находим элементы
        tv = findViewById(R.id.textView);
        chb = findViewById(R.id.chbExtMenu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // добавляем пункты меню
        menu.add(0, 1, 0, "add");
        menu.add(0, 2, 0, "edit");
        menu.add(0, 3, 3, "delete");
        menu.add(1, 4, 1, "copy");
        menu.add(1, 5, 2, "paste");
        menu.add(1, 6, 5, "exit");
        menu.add(1, 7, 4, "test1");
        menu.add(1, 8, 4, "test2");
        menu.add(1, 9, 4, "test3");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 6) {
            finish();
        }

        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();

        // Выведем в TextView информацию о нажатом пункте меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: ").append(item.getGroupId());
        sb.append("\r\n itemId: ").append(item.getItemId());
        sb.append("\r\n order: ").append(item.getOrder());
        sb.append("\r\n title: ").append(item.getTitle());
        tv.setText(sb.toString());

        return super.onOptionsItemSelected(item);
    }


}