package com.example.semifinaluclmodul_recyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DataPemain extends AppCompatActivity {

    private Data data;

    private ImageView logo;
    private TextView nama, detail;

    private String[] detail_tim = new String[] {"David de Gea, Dean Henderson, Sergio Romero, Lee Grant.\n" +
            "\n" +
            "Harry Maguire, Victor Lindelof, Eric Bailly, Marcos Rojo, Axel Tuanzebe, Phil Jones, Alex Telles, Luke Shaw, Brandon Williams, Aaron Wan-Bissaka, Timothy Fosu-Mensah.\n" +
            "\n" +
            "Nemanja Matic, Paul Pogba, Donny van de Beek, Scott McTominay, Fred, Bruno Fernandes, Jesse Lingard, Juan Mata.\n" +
            "\n" +
            "Marcus Rashford, Daniel James, Anthony Martial, Mason Greenwood, Odion Ighalo, Facundo Pellistri, Edinson Cavani.", "Alphonse Areola , Thibaut Courtois , Diego Altube, Javier Belman\n" +
            "\n" +
            "Dani Carvajal, Éder Militão, Sergio Ramos, Raphaël Varane, Nacho, Marcelo, Ferland Mendy, Sergio López, Fran García, Adri, Javi, Víctor Chust\n" +
            "\n" +
            "Toni Kroos, Luka Modrić, Gareth Bale, Casemiro, Federico Valverde, James Rodríguez, Marco Asensio, Brahim Díaz, Isco, Martín, Franchu, Álvaro Bravo, Marvin Park, Miguel Baeza, Antonio Blanco\n" +
            "\n" +
            "Eden Hazard, Karim Benzema, Lucas Vázquez, Luka Jović, Mariano Díaz, Vinícius Júnior, Rodrygo",
                                    "Kepa (1), Willy Caballero (13), Jamie Cumming (31)*, Nicolas Tie (50)*\n" +
                                            "\n" +
                                            "Antonio Rüdiger (2), Marcos Alonso (3), Andreas Christensen (4), Kurt Zouma (15), Reece James (24)*, César Azpilicueta (28), Fikayo Tomori (29), Emerson (33)\n" +
                                            "\n" +
                                            "Jorginho (5), N'Golo Kanté (7), Ross Barkley (8), Willian (10), Ruben Loftus-Cheek (12), Mateo Kovačić (17), Mason Mount (19)*, Callum Hudson-Odoi (20)*, Christian Pulišić (22), Billy Gilmour (47)*\n" +
                                            "\n" +
                                            "Tammy Abraham (9), Pedro Rodríguez (11), Olivier Giroud (18), Michy Batshuayi (23)","Marc-André ter Stegen, Neto, Iñaki Peña, Arnau Tenas\n" +
            "\n" +
            "Nélson Semedo, Gerard Piqué, Clément Lenglet, Jordi Alba, Samuel Umtiti, Junior Firpo, Guillem Jaime, Ronald Araújo, Dani Morer, Sergio Akieme \n" +
            "\n" +
            "Ivan Rakitić, Sergio Busquets, Arthur, Sergi Roberto, Frenkie de Jong, Arturo Vidal, Ricard Puig, Álex Collado, Ferrán Sarsanedas\n" +
            "\n" +
            "Luis Suárez, Lionel Messi, Ousmane Dembélé, Antoine Griezmann, Ansu Fati, Hiroki Abe, Kike Saverio, Rei Manaj"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);

        int posisi = getIntent().getIntExtra("posisi",0);

        data = new Data();
        logo = findViewById(R.id.detail_logo_team);
        nama = findViewById(R.id.detail_nama_team);
        detail = findViewById(R.id.detail_detail_team);

        logo.setImageResource(data.getThumbnail(posisi));
        nama.setText(data.getTitle(posisi));
        detail.setText(detail_tim[posisi]);
    }
}