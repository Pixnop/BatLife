package leon.fievet.batlife.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import leon.fievet.batlife.R;

public class EtatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etat);

        Button fullButton = findViewById(R.id.full_button);
        Button lowButton = findViewById(R.id.low_button);
        Button storageButton = findViewById(R.id.storage_button);

        fullButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Traiter le clic sur le bouton Full
                // ...
                setResult(Activity.RESULT_OK, new Intent().putExtra("etat", "Full"));
                finish();
            }
        });

        lowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Traiter le clic sur le bouton Low
                // ...
                setResult(Activity.RESULT_OK, new Intent().putExtra("etat", "Low"));
                finish();
            }
        });

        storageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Traiter le clic sur le bouton Storage
                // ...
                setResult(Activity.RESULT_OK, new Intent().putExtra("etat", "Storage"));
                finish();
            }
        });
    }
}
