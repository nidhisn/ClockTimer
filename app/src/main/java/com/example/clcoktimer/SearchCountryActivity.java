package com.example.clcoktimer;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class SearchCountryActivity extends AppCompatActivity {
    ArrayList<Country> countryArrayList = new ArrayList<>();
    private static final String TAG="SearchCountry";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_country);
        initUI();
    }


    private void initUI(){
        //String[] language ={"Japan","USA","China","Italy","Australia","England","Canada"};


        countryArrayList.add(new Country("Afghanistan, Kabul",-60 ));
        countryArrayList.add(new Country("Albania, Tirana",-198));
        countryArrayList.add(new Country("Algeria, Algiers", -258));
        countryArrayList.add(new Country("Andorra, Andorra La Vella", -198));
        countryArrayList.add(new Country("Argentina, Buenos Aires",-498));
        countryArrayList.add(new Country("Argentina, Córdoba, Córdoba", -498));
        countryArrayList.add(new Country("Armenia, Yerevan",-78));
        countryArrayList.add(new Country("Australia, New South Wales, Sydney ",318 ));
        countryArrayList.add(new Country("Australia, Northern Territory, Darwin", 240));
        countryArrayList.add(new Country("Australia, Victoria, Melbourne ",318));
        countryArrayList.add(new Country("Austria, Vienna, Vienna ",-198));
        countryArrayList.add(new Country("Bahamas, Nassau",-540));
        countryArrayList.add(new Country("Bahrain, Manama",-120));
        countryArrayList.add(new Country("Bangladesh, Dhaka",18));
        countryArrayList.add(new Country("Barbados, Bridgetown",-558));
        countryArrayList.add(new Country("Belarus, Minsk",-120));
        countryArrayList.add(new Country("Belgium, Brussels, Brussels ",-180));
        countryArrayList.add(new Country("Belize, Belmopan",-660));
        countryArrayList.add(new Country("Benin, Porto Novo",-240));
        countryArrayList.add(new Country("Bermuda, Hamilton",-498));
        countryArrayList.add(new Country("Bhutan, Thimphu", 18));
        countryArrayList.add(new Country("Bolivia, La Paz",-540));
        countryArrayList.add(new Country("Brazil, Acre, Rio Branco",-600));
        countryArrayList.add(new Country("Bulgaria, Sofia ",-120));
        countryArrayList.add(new Country("Cabo Verde, Praia",-360));
        countryArrayList.add(new Country("Cambodia, Phnom Penh",78));
        countryArrayList.add(new Country("Cameroon, Yaoundé", -258));
        countryArrayList.add(new Country("Canada, Alberta, Calgary",-660));
        countryArrayList.add(new Country("Canada, British Columbia, Vancouver ",-720));
        countryArrayList.add(new Country("Canada, Manitoba, Winnipeg ",-618));
        countryArrayList.add(new Country("Chile, Santiago ",-498));
        countryArrayList.add(new Country("China, Guangdong, Shenzhen",120));
        countryArrayList.add(new Country("China, Xinjiang, Ürümqi",120));
        countryArrayList.add(new Country("China, Tibet, Lhasa", 120));
        countryArrayList.add(new Country("China, Shanghai Municipality, Shanghai", 120));
        countryArrayList.add(new Country("Colombia, Bogota",-618));
        countryArrayList.add(new Country("Costa Rica, San Jose",-678));
        countryArrayList.add(new Country("Cuba, Havana",-558));
        countryArrayList.add(new Country("Denmark, Copenhagen ",-198));
        countryArrayList.add(new Country("Dominica, Roseau",-540));
        countryArrayList.add(new Country("Dominican Republic, Santo Domingo",-540));
        countryArrayList.add(new Country("Ecuador, Quito",-618));
        countryArrayList.add(new Country("Egypt, Cairo",-138));
        countryArrayList.add(new Country("Ethiopia, Addis Ababa",-138));
        countryArrayList.add(new Country("Falkland Islands, Stanley",-498));
        countryArrayList.add(new Country("Fiji, Suva",378));
        countryArrayList.add(new Country("Finland, Helsinki",-138));
        countryArrayList.add(new Country("Finland, Kemi",-138));
        countryArrayList.add(new Country("Finland, Rovaniemi",-138));
        countryArrayList.add(new Country("France, Paris, Paris",-180));
        countryArrayList.add(new Country("French Guiana, Cayenne",-480));
        countryArrayList.add(new Country("French Polynesia, Tahiti, Papeete",-918));
        countryArrayList.add(new Country("French Southern Territories, Amsterdam Island",-18));
        countryArrayList.add(new Country("Gabon, Libreville",-258));
        countryArrayList.add(new Country("Georgia, Tbilisi",-78));
        countryArrayList.add(new Country("Germany, Berlin, Berlin",-198));
        countryArrayList.add(new Country("Germany, Hesse, Frankfurt ",-198));
        countryArrayList.add(new Country("Ghana, Accra",-318));
        countryArrayList.add(new Country("Greenland, Danmarkshavn",-318));
        countryArrayList.add(new Country("Hong Kong, Hong Kong",138));
        countryArrayList.add(new Country("Hungary, Budapest ",-198));
        countryArrayList.add(new Country("Iceland, Reykjavik",-318));
        countryArrayList.add(new Country("Indonesia, Bali, Denpasar", 138));
        countryArrayList.add(new Country("Indonesia, East Java, Surabaya",78));
        countryArrayList.add(new Country("Indonesia, East Kalimantan, Balikpapan",138));
        countryArrayList.add(new Country("Indonesia, North Sulawesi, Manado", 138));
        countryArrayList.add(new Country("Iran, Tehran", -120));
        countryArrayList.add(new Country("Iraq, Baghdad",-138));
        countryArrayList.add(new Country("Ireland, Dublin ", -258));
        countryArrayList.add(new Country("Israel, Jerusalem", -138));
        countryArrayList.add(new Country("Italy, Rome",-198));
        countryArrayList.add(new Country("Jamaica, Kingston", -618));
        countryArrayList.add(new Country("Japan, Kobe", 198));
        countryArrayList.add(new Country("Japan, Kyoto",198));
        countryArrayList.add(new Country("Japan, Osaka", 198));
        countryArrayList.add(new Country("Japan, Tokyo", 198));
        countryArrayList.add(new Country("Japan, Yokohama", 198));
        countryArrayList.add(new Country("Kazakhstan, Almaty",18));
        countryArrayList.add(new Country("Kenya, Nairobi", -138));
        countryArrayList.add(new Country("Kuwait, Kuwait City",-138 ));
        countryArrayList.add(new Country("Latvia, Riga", -138));
        countryArrayList.add(new Country("Lebanon, Beirut ", -138));
        countryArrayList.add(new Country("Lithuania, Vilnius ", -138));
        countryArrayList.add(new Country("Madagascar, Antananarivo",-138));
        countryArrayList.add(new Country("Malawi, Lilongwe",-198));
        countryArrayList.add(new Country("Malaysia, Kuala Lumpur, Kuala Lumpur",138 ));
        countryArrayList.add(new Country("Maldives, Male",-18));
        countryArrayList.add(new Country("Mali, Bamako",-318));
        countryArrayList.add(new Country("Mexico, Guerrero, Acapulco",-678));
        countryArrayList.add(new Country("Monaco, Monaco",-198));
        countryArrayList.add(new Country("Myanmar, Naypyidaw", 60));
        countryArrayList.add(new Country("Nepal, Kathmandu",9));
        countryArrayList.add(new Country("Netherlands, Amsterdam",-198));
        countryArrayList.add(new Country("New Zealand, Auckland ",438));












        ArrayList<String> countryNameList = new ArrayList<>();
        //countryArrayList.forEach();
        for (Country c : countryArrayList){
            countryNameList.add(c.name);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, countryNameList );
        AutoCompleteTextView actv =  (AutoCompleteTextView)findViewById(R.id.autoCountrySuggestion);
        actv.setThreshold(1);
        actv.setAdapter(adapter);






        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = (String) adapterView.getItemAtPosition(i);
                Log.d(TAG, "onItemSelected: "+selectedItem);

                for (Country c : countryArrayList){

                    if (selectedItem.contains(c.name)){
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result",c);
                        setResult(MainActivity.LAUNCH_SEARCH_ACTIVITY,returnIntent);
                        finish();

                    }

                }

            }
        });

    }



}