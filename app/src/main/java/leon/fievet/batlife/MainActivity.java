package leon.fievet.batlife;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addBat(View v) {
        Intent intent = new Intent(this, addBatActivity.class);
        startActivity(intent);
    }

    public void updateBat(View v) {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(updateBatScanActivity.class);
        barLaucher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result -> {
        {
            if (result.getContents() != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Battery ID");
                builder.setMessage(result.getContents());
                builder.setPositiveButton("voir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Traitement à effectuer lors du clic sur le bouton "voir"
                        // ...
                        dialogInterface.dismiss(); // Fermer la fenêtre de dialogue
                    }
                });
                builder.setNegativeButton("Etat", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Traitement à effectuer lors du clic sur le bouton "Etat"
                        // ...
                        dialogInterface.dismiss(); // Fermer la fenêtre de dialogue
                        Intent intent = new Intent(MainActivity.this, EtatActivity.class); // Créer un nouvel Intent pour lancer l'activité EtatActivity
                        startActivity(intent);
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Traitement à effectuer lors du clic sur le bouton "Cancel"
                        // ...
                        dialogInterface.dismiss(); // Fermer la fenêtre de dialogue
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }
    });
}