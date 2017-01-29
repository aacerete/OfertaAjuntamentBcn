package com.example.a46990527d.ofertaajuntamentbcn;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsActivityFragment extends Fragment {

    ExpandableAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Proves>> listDataChild;

    public DetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        Intent i = getActivity().getIntent();
        if (i != null) {
            Selection seleccio = (Selection) i.getSerializableExtra("seleccio");

            if (seleccio != null) {

                TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
                tvTitle.setText( seleccio.getConvocatories().get(seleccio.getConvocatories().size()-1).getTitle());
                TextView tvSubtitle = (TextView) view.findViewById(R.id.tvSubtitle);
                tvSubtitle.setText( seleccio.getEns() + " - " + seleccio.getTipus());
                TextView tvDates = (TextView) view.findViewById(R.id.tvDates);
                tvDates.setText(seleccio.getIniciPresentacio() + " - " + seleccio.getFiPresentacio());
                TextView tvEstat = (TextView) view.findViewById(R.id.tvPlaces) ;
                tvEstat.setText("prova");

                Date today = new Date();
                String date = seleccio.getFiPresentacio();
                System.out.println(date);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                Date fin = null;
                try {
                    fin = sdf.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (today.after(fin)){
                    tvEstat.setText(" Sol·licituds tancades ");
                    tvEstat.setTextColor(getResources().getColor(R.color.colorClosed));
                }else{
                    tvEstat.setText("Sol·licituds obertes");
                    tvEstat.setTextColor(getResources().getColor(R.color.colorOpened));

                }

                // get the listview
                expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

                listDataHeader = new ArrayList<String>();
                listDataChild = new HashMap<String, List<Proves>>();

                // Adding child data
                listDataHeader.add("Convocatories");
                listDataHeader.add("Sol·licituds de participació");
                listDataHeader.add("Convocatòries a proves i entrevistes");
                listDataHeader.add("Anuncis , avisos i llistes d'admesos i exclosos");
                listDataHeader.add("Resultats de les proves");
                listDataHeader.add("Resolucions");

                listDataChild.put(listDataHeader.get(0), seleccio.getConvocatories());
                listDataChild.put(listDataHeader.get(1), seleccio.getSollicitudsParticipacions());
                listDataChild.put(listDataHeader.get(2), seleccio.getConvocatoriesProvesEntrevistes());
                listDataChild.put(listDataHeader.get(3), seleccio.getLlistatsAdmesosExclosos());
                listDataChild.put(listDataHeader.get(4), seleccio.getResultatsProvesEntrevistes());
                listDataChild.put(listDataHeader.get(5), seleccio.getResolucionsConvocatories());


                listAdapter = new ExpandableAdapter(getContext(), listDataHeader, listDataChild);

                // setting list adapter
                expListView.setAdapter(listAdapter);


                expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v,
                                                int groupPosition, int childPosition, long id) {

                        Proves prova = (Proves) listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                        if(prova.getDoc() != null){
                            Uri uri = Uri.parse(prova.getDoc()); // missing 'http://' will cause crashed
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }else if(prova.getUrl() != null){
                            Uri uri = Uri.parse(prova.getUrl()); // missing 'http://' will cause crashed
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                        return false;
                    }
                });
                //updateUi(seleccio);
            }
        }
        return view;
    }
}
