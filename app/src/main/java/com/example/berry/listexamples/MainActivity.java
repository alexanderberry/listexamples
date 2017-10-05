package com.example.berry.listexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private List<SuperHero> heroes;
    private ListView heroListView;
    private ArrayAdapter<SuperHero> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heroListView = (ListView) findViewById(R.id.listview_hero);
        createSuperheroes();
        adapter = new ArrayAdapter<SuperHero>(this, android.R.layout.simple_list_item_1, heroes);
        heroListView.setAdapter(adapter);
        heroListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, heroes.get(i).getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, HeroActivity.class);
                intent.putExtra("heroName", heroes.get(i));
                intent.putExtra("heroDescription", heroes.get(i));
                intent.putExtra("image", heroes.get(i));
                intent.putExtra("ranking", heroes.get(i));
                startActivity(intent);
            }
        });
        registerForContextMenu(heroListView);
    }

    private void createSuperheroes() {
        heroes = new ArrayList<>();
        heroes.add(new SuperHero("Batman", "A man without powers, much like a bat.",30, R.drawable.bart));
        heroes.add(new SuperHero("Manbat", "Half man, half bat, all disgusting.",10,R.drawable.manbat));
        heroes.add(new SuperHero("Catman", "Just a normal man that's overly attracted to laser pointers.",15, R.drawable.catman));
        heroes.add(new SuperHero("Notman", "Some sort of animal. The only thing we can tell is that it's definitely not a man.",90, R.drawable.notman));
        heroes.add(new SuperHero("Baseballbatman", "It's a man, but all his limbs are baseball bats.",100,R.drawable.baseballbatman));
        heroes.add(new SuperHero("Animalbatman", "Same thing as baseballbatman but all his limbs are normal bats.",1, R.drawable.normalbatman));
        heroes.add(new SuperHero("Datman", "That guy standing next to you.",150, R.drawable.man));
        heroes.add(new SuperHero("Chi", "Defeats experienced programmers with bad commit messages.",2,R.drawable.chi));
        heroes.add(new SuperHero("Ken", "Flies a drone into the enemy.",20, R.drawable.ken));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int i = info.position;
        switch (item.getItemId()){
            case R.id.menu_item_open:
                Intent intent = new Intent(MainActivity.this, HeroActivity.class);
                intent.putExtra("heroName", heroes.get(i).getName());
                intent.putExtra("heroDescription", heroes.get(i).getDescription());
                intent.putExtra("image", heroes.get(i).getResourceId());
                startActivity(intent);
                break;
            case R.id.menu_item_delete:
                adapter.remove(heroes.get(i));
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return super.onContextItemSelected(item);
    }
}
