package br.ufmg.coltec.e04_actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // recupera id do item selecionado
        int id = item.getItemId();

        // verifica qual é o botão selecionado com base no id
        switch (id) {
            case R.id.action_atualizar:
                Toast.makeText(this, "Item atualizado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_buscar:
                Toast.makeText(this, "Clicou no buscar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_compartilhar:
                Toast.makeText(this, "Clicou no compartilhar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_configuracoes:
                Toast.makeText(this, "Clicou no compartilhar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_about:
                informacoesApp();
                return true;
            case R.id.action_sair:
                finish();
                return true;
            default: return super.onOptionsItemSelected(item);

        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);

        // recupera share provider
        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider shareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        // criar intent que será exibida pelo provider
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Texto para Compartilhar");

        // exibe a intent
        shareProvider.setShareIntent(intent);

        return true;
    }*/

    public void informacoesApp() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        alertBuilder.setIcon(R.drawable.ic_launcher_foreground);
        alertBuilder.setTitle("Informações do App");
        alertBuilder.setMessage("Feito por: Jeferson Constantino");

        alertBuilder.setPositiveButton("Sair", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "Saindo das informacoes", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = alertBuilder.create();
        dialog.show();
    }
}