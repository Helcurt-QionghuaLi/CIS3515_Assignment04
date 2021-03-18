package edu.temple.cis3515_assignment05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] AnimeNames = {"Attack On Titan", "Bleach", "Natuto", "One Piece", "One Punch Man"};

    int[] AnimeImages = {R.drawable.attackontitan, R.drawable.bleach, R.drawable.naruto,
    R.drawable.onepiece, R.drawable.onepunchman};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Selection Activity");

        gridView =findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                intent.putExtra("name", AnimeNames[position]);
                intent.putExtra("image", AnimeImages[position]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return AnimeImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.anime_selection, null);

            TextView name = view1.findViewById(R.id.anime);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(AnimeNames[position]);
            image.setImageResource(AnimeImages[position]);
            return view1;
        }
    }
}