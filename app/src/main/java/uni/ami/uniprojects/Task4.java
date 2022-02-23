package uni.ami.uniprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Task4 extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText mainEditText;
    private Button buttonTask4Cancel;
    private Button  buttonTask4AddToList;
    private ListView listView;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        listView = findViewById(R.id.listView);
        mainEditText = findViewById(R.id.main_edittext);
        buttonTask4AddToList = findViewById(R.id.buttonTask4AddToList);

        mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(mArrayAdapter);

        buttonTask4AddToList.setOnClickListener(view -> {
            String name = mainEditText.getText().toString();
            if (!arrayList.contains(name)) {
                arrayList.add(mainEditText.getText().toString());
                Collections.sort(arrayList);
            }
            mArrayAdapter.notifyDataSetChanged();
        });
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        arrayList.remove(position);
        mArrayAdapter.notifyDataSetChanged();
    }
}