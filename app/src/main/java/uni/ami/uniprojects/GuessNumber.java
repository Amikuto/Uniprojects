package uni.ami.uniprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class GuessNumber extends AppCompatActivity {
    private Button buttonCheck;
    private TextView guessedNumber;
    private TextView editGuessRange;
    private TextView textResult;

    private final Random random = new Random();
    private int randomRange = 100;
    private Integer generatedNumber = generateNumber(randomRange);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number);

        buttonCheck = findViewById(R.id.buttonCheck);
        guessedNumber = findViewById(R.id.GuessedNumber);
        editGuessRange = findViewById(R.id.editGuessRange);
        textResult = findViewById(R.id.textResult);

        buttonCheck.setOnClickListener(view -> {
            try {
                Integer gNum = Integer.parseInt(guessedNumber.getText().toString());

                int compare = gNum.compareTo(generatedNumber);

                if (compare < 0) {
                    Toast.makeText(getApplicationContext(), "guessed number is SMALLER than needed", Toast.LENGTH_LONG).show();
                } else if (compare > 0) {
                    Toast.makeText(getApplicationContext(), "guessed number is LARGER than needed", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Gratz! New number is generated", Toast.LENGTH_LONG).show();
                    generateNumber(randomRange);
                }
            } catch (NumberFormatException exception) {
                Toast.makeText(getApplicationContext(), "Empty guessed number!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private Integer generateNumber(int range) {
        return random.nextInt(range);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // добавляем пункты меню
        menu.add(0, 1, 0, "level 1");
        menu.add(0, 2, 0, "level 2");
        menu.add(0, 3, 0, "level 3");
        menu.add(0, 4, 1, "exit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();

        switch (itemID) {
            case 1: {
                generateNumber(100);
                Toast.makeText(getApplicationContext(), "Try to guess! (0-100)", Toast.LENGTH_LONG).show();
                break;
            }
            case 2: {
                generateNumber(300);
                Toast.makeText(getApplicationContext(), "Try to guess! (0-300)", Toast.LENGTH_LONG).show();
                break;
            }
            case 3: {
                generateNumber(500);
                Toast.makeText(getApplicationContext(), "Try to guess! (0-500)", Toast.LENGTH_LONG).show();
                break;
            }
            case 4:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}