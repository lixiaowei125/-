package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

//自定义适配器，继承自ArrayAdapter
public class beiwangluAdapter extends ArrayAdapter<beiwangluContent> {
    //resourceID指定ListView的布局方式
    private int resourceID;

    //重写beiwangluAdapter的构造器
    public beiwangluAdapter(Context context, int textViewResourceID, List<beiwangluContent> objects) {
        super(context, textViewResourceID, objects);
        resourceID = textViewResourceID;
    }

    //自定义item资源的解析方式
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //获取当前NoteContent实例
        beiwangluContent beiwanglu = getItem(position);
        View view;
        ViewHolder viewHolder;
        /*if(convertView == null){*/
        view = LayoutInflater.from(getContext()).inflate(resourceID, null);
        viewHolder = new ViewHolder();
        viewHolder.noteDate = (TextView) view.findViewById(R.id.note_Date);
        viewHolder.noteContent = (TextView) view.findViewById(R.id.note_Content);
        //将ViewHolder存储在View中
        view.setTag(viewHolder);
      /*}else {
         view = convertView;
         viewHolder = (ViewHolder)view.getTag();
      }*/
        //引入beiwangluContent对象的属性值
        viewHolder.noteDate.setText(beiwanglu.getDate());
        viewHolder.noteContent.setText(beiwanglu.getContent());
        return view;
    }

    class ViewHolder {
        TextView noteDate;
        TextView noteContent;
    }
}
