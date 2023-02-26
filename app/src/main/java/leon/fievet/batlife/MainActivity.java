package leon.fievet.batlife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addBat(View v){
        Intent intent = new Intent(this, addBatActivity.class);
        startActivity(intent);
    }
    public void updateBat(View v){
        Intent intent = new Intent(this, updateBatActivity.class);
        Button button = (Button) v;
        intent.putExtra("lvlCharge", button.getText());
        startActivity(intent);
    }
}