package edu.temple.colorpalette;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity {


//    String[] myColors = {"White", "Red", "Blue", "Grey", "Yellow", "Cyan"};
    String[] myColors = {"No selection", "Red", "Blue", "Grey", "Yellow", "Cyan"};
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);


        ll = (LinearLayout)findViewById(R.id.activity_palette);

        Spinner s = (Spinner)findViewById(R.id.spinner);

        final ColorAdapter colorAdapter = new ColorAdapter(this, myColors);


        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                view = findViewById(R.id.activity_palette);
//                view.setBackgroundColor(Color.parseColor(colorAdapter.getItem(i).toString()));

                try {
                    view.setBackgroundColor(Color.parseColor(colorAdapter.getItem(i).toString()));
                } catch (IllegalArgumentException e) {
                    //Toast.makeText(PaletteActivity.this, "Select color.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                ll.setBackgroundColor(Color.parseColor("White"));
            }
        });



        s.setAdapter(colorAdapter);





    }
}
