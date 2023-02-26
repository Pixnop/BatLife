package leon.fievet.batlife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class updateBatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bat);
        Intent intent = getIntent();
        String lvlCharge = intent.getStringExtra("lvlCharge");
        ((TextView)findViewById(R.id.textView)).setText(lvlCharge);
    }
}