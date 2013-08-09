package com.example.flights;

import java.util.ArrayList;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 24.07.13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
public class FAdapter extends BaseAdapter {
    private ArrayList<flight> FlList;
    private int layout;
    private Context context;

    public BlogAdapter(Context context, int layout, ArrayList<flight>FlList) {
        this.context = context;
        this.FlList = FlList;
        this.layout = layout;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return FlList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(layout, null);
        }

        flight aFlight = FlList.get(position);

        TextView txt1 = (TextView) convertView.findViewById(R.id.txt1);
        TextView txt2 = (TextView) convertView.findViewById(R.id.txt2);

        txt1.setText(Html.fromHtml(aFlight.getcost()));   //дописать другие поля в соответствии с тем,что выдает сервер
        txt2.setText(Html.fromHtml(aFlight.getldate()));
        //добавить помещение изображения: либо поместить логотипы в ресурсы либо сделать базу данных с логотипами.передавать их с сервера не имеет смысла.

        return convertView;
    }
}
