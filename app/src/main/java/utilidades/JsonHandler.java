package utilidades;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import modelos.Usuario;

/**
 * Created by bpastene on 20-05-16.
 */
public class JsonHandler{
    /**
     * Método que recibe un JSONArray en forma de String y devuelve un String[] con los actores
     */
    public Usuario[] getActors(String actors) {
        try {
            JSONArray ja = new JSONArray(actors);
            Usuario[] result = new Usuario[ja.length()];
            Usuario actor;
            for (int i = 0; i < ja.length(); i++) {
                JSONObject row = ja.getJSONObject(i);
                actor = new Usuario(row.getString("user"), row.getString("pass"),row.getString("mail"));
                result[i] = actor;
            }
            return result;
        } catch (JSONException e) {
            Log.e("ERROR", this.getClass().toString() + " " + e.toString());
        }
        return null;
    }// getActors(String actors)


    public JSONArray getJsonActor(Usuario actor) {
        try {
            JSONArray ja = new JSONArray().put(actor);
            return ja;
        } catch (Exception e) {
            Log.e("ERROR", this.getClass().toString() + " " + e.toString());
        }
        return null;
    }// getActors(String actors)

}