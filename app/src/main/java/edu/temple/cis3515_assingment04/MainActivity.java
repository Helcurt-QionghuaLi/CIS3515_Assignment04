package edu.temple.cis3515_assingment04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    Spinner spinner;

    int[] animeImagesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Selection Activity");

        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        ArrayList animesArray = new ArrayList<String>();
        animesArray.add("Bleach");
        animesArray.add("Naruto");
        animesArray.add("One Piece");
        animesArray.add("Attack On Titan");
        animesArray.add("One Punch Man");


        animeImagesArray = new int[]{R.drawable.bleach, R.drawable.naruto, R.drawable.onepiece, R.drawable.attackontitan, R.drawable.onepunchman};
        AnimeAdapter adapter = new AnimeAdapter(this, animesArray, animeImagesArray);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    // Must account for title view, which is at position 0
                    // first selectable item will therefore be position 1
                    showPicture(position - 1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

    }
    private void showPicture (int position) {
        imageView.setImageResource(animeImagesArray[position]);
    }
}