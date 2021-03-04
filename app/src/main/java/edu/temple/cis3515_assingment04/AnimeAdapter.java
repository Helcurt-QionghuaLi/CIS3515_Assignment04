package edu.temple.cis3515_assingment04;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;

import android.media.Image;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimeAdapter extends BaseAdapter {


    Context context;
    ArrayList<String> items;
    int[] imageRes;
    String instruction = "Select your favorite anime"; // Instruction to show for as first item



    public AnimeAdapter (Context context, ArrayList items, int[] imageRes) {
        this.context = context;
        this.items = items;
        this.imageRes = imageRes;


    }

    /**
     * Determine if the item at this position should be title
     * @param position
     * @return
     */
    private boolean isTitle(int position) {
        return position == 0;
    }

    @Override
    public int getCount() {
        // Number of posible views is one more than collection size
        // because of title view
        return items.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        // Don't return anything if this is the title
        // because it won't be selectable
        if (isTitle(position))
            return null;
        else
            return items.get(position + 1);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;

        // Create centered TextView
        if ((textView = (TextView) convertView) == null) {
            textView = new TextView(context);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setTextSize(22);
        }

        // Show instruction instead of item if at first position
        if (isTitle(position))
            textView.setText(instruction);
        else
            textView.setText(items.get(position - 1));

        return textView;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        // If first position, simply return title
        if (isTitle(position)) return getView(position, null, parent);

        TextView textView;
        ImageView imageView;

        LinearLayout linearLayout;

        if (convertView instanceof TextView || convertView == null) {
            linearLayout = new LinearLayout(context);
            textView = new TextView(context);
            imageView = new ImageView(context);
            textView.setPadding(10,15,15,15);
            textView.setTextSize(22);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(imageView);
            imageView.getLayoutParams().height = 150;
            imageView.getLayoutParams().width = 150;
            linearLayout.addView(textView);
        } else {
            linearLayout = (LinearLayout) convertView;
            imageView = (ImageView) linearLayout.getChildAt(0);
            textView = (TextView) linearLayout.getChildAt(1);
        }

        // 'position' will always include 0, which is title
        // if we get here, then we want to look at one item prior
        textView.setText(items.get(position - 1));
        imageView.setImageResource(imageRes[position - 1]);

        return linearLayout;
    }
}