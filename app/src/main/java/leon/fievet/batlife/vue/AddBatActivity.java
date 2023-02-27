package leon.fievet.batlife.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import leon.fievet.batlife.R;

public class AddBatActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bat);
    }

    private ImageView qrCodeIV;
    private EditText marque;
    private EditText modele;
    private EditText type;
    private EditText connectique;
    private EditText capacite;
    private EditText puissance;
    private EditText autonomie;
    private EditText prix;
    private EditText poids;
    private EditText taille;
    private EditText nbCellules;


    Bitmap bitmap;
    BitMatrix bitMatrix ;

    public void addBat(View view) throws IOException, WriterException {
        qrCodeIV = findViewById(R.id.affichageQR);
        marque = findViewById(R.id.marque);
        modele = findViewById(R.id.modele);
        type = findViewById(R.id.type);
        connectique = findViewById(R.id.connectique);
        capacite = findViewById(R.id.capacite);
        puissance = findViewById(R.id.puissance);
        autonomie = findViewById(R.id.autonomie);
        prix = findViewById(R.id.prix);
        poids = findViewById(R.id.poids);
        taille = findViewById(R.id.taille);
        nbCellules = findViewById(R.id.nbCellules);

        String data = marque.getText().toString()
                + modele.getText().toString()
                + type.getText().toString()
                + connectique.getText().toString()
                + capacite.getText().toString()
                + puissance.getText().toString()
                + autonomie.getText().toString()
                + prix.getText().toString()
                + poids.getText().toString()
                + taille.getText().toString()
                + nbCellules.getText().toString();

        bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);

        int[] pixels = new int[bitMatrix.getHeight() * bitMatrix.getWidth()];
        for (int y = 0; y < bitMatrix.getHeight(); y++) {
            int offset = y * bitMatrix.getWidth();
            for (int x = 0; x < bitMatrix.getWidth(); x++) {
                pixels[offset + x] = bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF;
            }
        }
        bitmap = Bitmap.createBitmap(bitMatrix.getWidth(), bitMatrix.getHeight(), Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrix.getWidth(), bitMatrix.getHeight());
        qrCodeIV.setImageBitmap(bitmap);

        String fileName = data + ".png";
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, fileName);
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
        values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/BatLife");
        Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        OutputStream outputStream = getContentResolver().openOutputStream(uri);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        outputStream.flush();
        outputStream.close();
    }
}