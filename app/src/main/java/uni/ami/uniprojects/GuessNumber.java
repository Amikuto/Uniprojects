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
    private Integer generatedNumber = generateNumber();

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

                if (gNum > randomRange) {
                    Toast.makeText(getApplicationContext(), "guessed number out of bounds!!!", Toast.LENGTH_LONG).show();
                } else {
                    int compare = gNum.compareTo(generatedNumber);

                    if (compare < 0) {
                        Toast.makeText(getApplicationContext(), "guessed number is SMALLER than needed", Toast.LENGTH_LONG).show();
                    } else if (compare > 0) {
                        Toast.makeText(getApplicationContext(), "guessed number is LARGER than needed", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Gratz! New number is generated", Toast.LENGTH_LONG).show();
                        generateNumber();
                    }
                }
            } catch (NumberFormatException exception) {
                Toast.makeText(getApplicationContext(), "Empty guessed number!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private Integer generateNumber() {
        return random.nextInt(randomRange);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
            case 1:
                randomRange = 100;
                generateNumber();
                Toast.makeText(getApplicationContext(), "Try to guess! (0-100)", Toast.LENGTH_LONG).show();
                break;

            case 2:
                randomRange = 300;
                generateNumber();
                Toast.makeText(getApplicationContext(), "Try to guess! (0-300)", Toast.LENGTH_LONG).show();
                break;

            case 3:
                randomRange = 500;
                generateNumber();
                Toast.makeText(getApplicationContext(), "Try to guess! (0-500)", Toast.LENGTH_LONG).show();
                break;

            case 4:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}