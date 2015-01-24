package hristova.examples.drawer.pager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hristova.examples.drawer.R;

/**
 * Created by radost on 1/24/15.
 */
public class PageFragment extends Fragment {

    public PageFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int backgroundColor;
        int pageNumber = getArguments().getInt("number", 0);
        switch (pageNumber) {
            case 1:
                backgroundColor = Color.parseColor("#37b2c4");
                break;
            case 2:
                backgroundColor = Color.parseColor("#7690cf");
                break;
            case 3:
                backgroundColor = Color.parseColor("#b60f2e");
                break;
            case 4:
                backgroundColor = Color.parseColor("#7ac142");
                break;
            case 5:
                backgroundColor = Color.parseColor("#f5ca9e");
                break;
            default:
                backgroundColor = Color.parseColor("#f6e1ff");
                break;

        }

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.page_item, container, false);
        rootView.setBackgroundColor(backgroundColor);
        TextView textView = (TextView) rootView.findViewById(R.id.textView);
        textView.setText("Page " + pageNumber);
        return rootView;
    }

}