package humble.slave.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_output);


        //TODO : passed values from the main activity
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            TextView output = findViewById(R.id.output);
            output.setText(extras.getString("string"));

            RelativeLayout outputLayout = findViewById(R.id.outputLayout);
            int colorCode;
            try {
                //TODO : the following piece of code for generating the integer value from a name of color is taken from this link : https://stackoverflow.com/questions/18143713/how-do-i-get-a-color-id-with-a-known-color-name
                colorCode = R.color.class.getField(extras.getString("color")).getInt(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            outputLayout.setBackgroundColor(getResources().getColor(colorCode));
        }
    }
}