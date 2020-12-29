package com.example.admobalwi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {

    ListView mListView;

    int[] images = {R.drawable.abid,
                    R.drawable.adi,
                    R.drawable.alwi,
                    R.drawable.arif,
                    R.drawable.deliyan,
                    R.drawable.gifari,
                    R.drawable.ibnu,
                    R.drawable.imem,
                    R.drawable.jordan,
                    R.drawable.kelvin,
                    R.drawable.kemal,
                    R.drawable.nafan,
                    R.drawable.rido,
                    R.drawable.rizal,
                    R.drawable.saroji,
                    R.drawable.syaikhul,
                    R.drawable.siyus};

    String[] names = {"Abid Rofiq",
                        "Adi Darmanto",
                        "Muhammad Alwi",
                        "Arief Fathul Hikam",
                        "Dellyan Ahmad",
                        "Ghifari Firdaus",
                        "Ibnu Kalimusodo",
                        "Imam Fauzi",
                        "Jordan Istiqlal",
                        "Kelvin Pradana",
                        "Kemal Ardiansayah",
                        "Naf'an Rasuidin",
                        "Muhammad Rido",
                        "Muhammad Rizal Muttaqin",
                        "Ahmad Saroji",
                        "Syaikhul Anam",
                        "Yusuf Siyus"};

    String[] job = {"Gaming International",
                    "Vidio Editor",
                    "Director Net.Tv",
                    "Programmer",
                    "Foto Editor",
                    "Web Service",
                    "Gaming International",
                    "Cloud Everything",
                    "Web Service",
                    "Gamers Pro",
                    "Programmer Full Stack",
                    "Back End Editor",
                    "Database Program",
                    "Ui & UX Program",
                    "Hardware Engineering",
                    "Mobile Programmer",
                    "Soft Engineering"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listview);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        mListView.setAdapter(customAdaptor);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View hay = getLayoutInflater().inflate(R.layout.customgan, null);

            ImageView mImageView = (ImageView) hay.findViewById(R.id.imageView);
            TextView mTextView = (TextView) hay.findViewById(R.id.textview);
            TextView mTextView1 = (TextView) hay.findViewById(R.id.textview1);

            mImageView.setImageResource(images[i]);
            mTextView.setText(names[i]);
            mTextView1.setText(job[i]);

            return hay;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_action);

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Yakin ingin Keluar aplikasi ini...?")
                .setCancelable(false)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
                    }
                })

                .setNegativeButton("Gak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}