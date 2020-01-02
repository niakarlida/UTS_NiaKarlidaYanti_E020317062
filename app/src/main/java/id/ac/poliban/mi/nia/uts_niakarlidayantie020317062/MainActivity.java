package id.ac.poliban.mi.nia.uts_niakarlidayantie020317062;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
    String pilAgama;
    String rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] pilihan = new String[] {
            "Pilih Agama", "Islam", "Kristen", "Hindu", "Budha", "Konghuchu", "Lainnya"
        };

        Spinner btSpinner = findViewById(R.id.btSpinner);
        ArrayAdapter<String> agama = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pilihan);
        agama.setDropDownViewResource( android.R.layout.simple_spinner_item);
        btSpinner.setAdapter(agama);

        btSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pilAgama = btSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText edNoPendaftaran = findViewById(R.id.edNoPendaftaran);
        EditText edNama = findViewById(R.id.edNama);
        final EditText edAlamat = findViewById(R.id.edAlamat);
        final EditText edTelp = findViewById(R.id.edTelp);

        RadioButton rbLakiLaki = findViewById(R.id.rbLakiLaki);
        RadioButton rbPerempuan = findViewById(R.id.rbPerempuan);
        RadioGroup radiogrup = findViewById((R.id.radiogrup));

        radiogrup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == rbLakiLaki.getId()){
                rb = rbLakiLaki.getText().toString();
            } else {
                rb = rbPerempuan.getText().toString();
            }
        });


        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(V-> {
            edNoPendaftaran.getText().clear();
            edNama.getText().clear();
            edAlamat.getText().clear();
            edTelp.getText().clear();
            btSpinner.setAdapter(agama);
            radiogrup.clearCheck();
            edNoPendaftaran.requestFocus();

        });

        Button btSubmit = findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(view -> new AlertDialog.Builder(this)
                .setTitle("Info Registrasi : ")
                .setMessage(
                        "No Pendaftaran : " + edNoPendaftaran.getText() + "\n" +
                        "Nama : " + edNama.getText() + "\n" +
                        "Jenis Kelamin : " + rb + "\n" +
                        "Agama : " + pilAgama + "\n" +
                        "Alamat : " + edAlamat.getText() + "\n" +
                        "Telepon : " + edTelp.getText())
                .setPositiveButton("OK", null)
                .show());

    }
}
