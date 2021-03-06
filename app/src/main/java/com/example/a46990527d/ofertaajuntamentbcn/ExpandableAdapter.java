package com.example.a46990527d.ofertaajuntamentbcn;

/**
 * Created by Usuario on 29/01/2017.
 */

import android.widget.BaseExpandableListAdapter;


        import java.util.HashMap;
        import java.util.List;

        import android.content.Context;
        import android.graphics.Typeface;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


//adaptador de la expandableListView que es troba al detailsActivity
public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // Cabeceras del expandable
    // Datos de los hijos, en formato header title, child title
    private HashMap<String, List<Proves>> _listDataChild;

    public ExpandableAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<Proves>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final Proves child = (Proves) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.tvTitle);
        ImageView imView = (ImageView) convertView.findViewById(R.id.imageView) ;

        //Si no hi ha info als childs , o comencen amb caracters
        if (child.getTitle().isEmpty() || child.getTitle().startsWith("--")){
            //mostrem que està pendent de publicar i amaguem les icones de pdf o http
            txtListChild.setText("Pendent de publicació");
            imView.setVisibility(View.INVISIBLE);
        }else{
            txtListChild.setText(child.getTitle());
            imView.setVisibility(View.VISIBLE);
        }

        //si comenza amb una uri valida
        if (child.getUrl().startsWith("htt")){
            //mostrem la icona de http
            imView.setImageResource(R.drawable.ic_action_name);

        }else {
            //mostrem icona de pdf
            imView.setImageResource(R.drawable.ic_picture_as_pdf_white_24px);
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
