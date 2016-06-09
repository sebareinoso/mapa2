package com.example.vanaheim.tester_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import Controladores.HttpGet;
import utilidades.JsonHandler;
import utilidades.SystemUtilities;

public class ValorarLugar extends Fragment {

    private BroadcastReceiver br = null;
    private final String URL_GET = "http://192.168.1.35:8080/backend-java/publicaciones/";
    private String[][] actorsList;

    /**
     * Constructor. Obligatorio para Fragmentos!
     */
    public ValorarLugar() {
    }// ItemList()

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.crear_usuario, container, false);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    /**
     * Método que escucha las pulsaciones en los items de la lista
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = "Nombre: "+actorsList[position][0].toString() + " " + actorsList[position][1].toString()+"\n";
        item = item + "Ultima actualizacion: " + actorsList[position][3]+ "\n";
        item = item + "ID actor: " + actorsList[position][2]+"\n";
        Bundle arguments = new Bundle();
        arguments.putString("item", item);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.commit();
    }// onListItemClick(ListView l, View v, int position, long id)

    /**
     * Método que se ejecuta luego que el fragmento es creado o restaurado
     */
    @Override
    public void onResume() {
        IntentFilter intentFilter = new IntentFilter("httpData");
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                JsonHandler jh = new JsonHandler();
                actorsList = jh.getPublicaciones(intent.getStringExtra("data"));
                String[] actorsNames = new String[actorsList.length];
                for (int i=0; i<actorsList.length;i++ ){
                    actorsNames[i]= " " + actorsList[i][0].toString() + " " + actorsList[i][1].toString();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity()
                        , android.R.layout.simple_list_item_1, actorsNames);
                setListAdapter(adapter);
            }
        };
        getActivity().registerReceiver(br, intentFilter);
        SystemUtilities su = new SystemUtilities(getActivity().getApplicationContext());
        if (su.isNetworkAvailable()) {
            new HttpGet(getActivity().getApplicationContext()).execute(URL_GET);
        }
        super.onResume();
    }// onResume()

    /**
     * Método que se ejecuta luego que el fragmento se detiene
     */
    @Override
    public void onPause() {
        if (br != null) {
            getActivity().unregisterReceiver(br);
        }
        super.onPause();
    }// onPause()
}
