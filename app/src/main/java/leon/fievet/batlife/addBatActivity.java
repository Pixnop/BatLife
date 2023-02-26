package leon.fievet.batlife;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Paths;

public class addBatActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bat);
    }

    private ImageView qrCodeIV;
    private EditText dataEdt;
    Bitmap bitmap;
    BitMatrix bitMatrix ;

    public void addBat(View view) throws IOException, WriterException {
        qrCodeIV = findViewById(R.id.affichageQR);
        dataEdt = findViewById(R.id.editTextBat);

        String data = dataEdt.getText().toString();

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
    }
}