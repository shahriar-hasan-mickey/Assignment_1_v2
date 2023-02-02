package humble.slave.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        TODO : for hiding the title bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
    }

    public void makeChanges(View view){
        Intent toNextActivity = new Intent(MainActivity.this, Output.class);
        Spinner spinner = findViewById(R.id.colorList);
        EditText enterTxt = findViewById(R.id.enterTxt);
        toNextActivity.putExtra("string", enterTxt.getText().toString());

        //TODO : the code snippet for extracting the selected item from spinner is taken from this link : https://stackoverflow.com/questions/52305827/how-can-i-retrieve-data-from-spinner-and-process-it
        toNextActivity.putExtra("color", spinner.getSelectedItem().toString());
        startActivity(toNextActivity);
    }
}