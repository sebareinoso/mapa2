package com.example.vanaheim.tester_1;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;

    /**
     * Método que se ejecuta al momento de crear la actividad, llama al fragmento que muestra una lista de elementos
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new MenuPrincipal());
        transaction.commit();
    }

    /**
     * Método que se ejecuta al momento de presionar el botón regresar del teclado
     */
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }// onBackPressed()

    /**
     * Método que crea el menú superior
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }// onCreateOptionsMenu(Menu menu)

    /**
     * Método que escucha los elementos presionados en el menú superior
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main_activity_add:
                if (!(getFragmentManager().findFragmentByTag("isActiveNewItem") != null && getFragmentManager().findFragmentByTag("isActiveNewItem").isVisible())) {
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, new CrearUsuario(), "isActiveNewItem");
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                break;
            case R.id.menu_main_activity_see:
                if (!(getFragmentManager().findFragmentByTag("isActiveNewItem") != null && getFragmentManager().findFragmentByTag("isActiveNewItem").isVisible())) {
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, new MostrarLugares(), "isActiveNewItem");
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                break;
            case R.id.menu_main_activity_exit:
                finish();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }// onOptionsItemSelected(MenuItem item)

    /**
     * Metodo para usar los textos para cambiar de pagina
     */
    public void onClickCrearUsuario(View v){
        /*TextView tv = (TextView)findViewById(R.id.text_ver_lugares);
        tv.setText("Swag");*/
        Fragment CrearUsuario = new CrearUsuario();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, CrearUsuario);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onClickVerLugares(View v){
        /*TextView tv = (TextView)findViewById(R.id.text_ver_lugares);
        tv.setText("Swag");*/
        Fragment MostrarLugares = new MostrarLugares();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, MostrarLugares);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
