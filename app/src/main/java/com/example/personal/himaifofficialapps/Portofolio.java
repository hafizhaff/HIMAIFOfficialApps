package com.example.personal.himaifofficialapps;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class Portofolio extends Fragment implements View.OnClickListener{

    public static ImageView himaLine,himaInsta,himaFb,himaTwitter,kontent,fifa,ifbf,pbif,mibHimaif,fortran,respect,pandaif,dnif,explosif;
    TextView judul;
    int[] daftarImage;
    public Portofolio() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_portofolio, container, false);

        daftarImage = new int[14];
        daftarImage[0]=R.drawable.logo_origin;
        daftarImage[1]=R.drawable.line;
        daftarImage[2]=R.drawable.instagram;
        daftarImage[3]=R.drawable.facebook;
        daftarImage[4]=R.drawable.twitter;
        daftarImage[5]=R.drawable.kontent;
        daftarImage[6]=R.drawable.fifa;
        daftarImage[7]=R.drawable.ifbf;
        daftarImage[8]=R.drawable.pbif;
        daftarImage[9]=R.drawable.logos;
        daftarImage[10]=R.drawable.line;
        daftarImage[11]=R.drawable.panda;
        daftarImage[12]=R.drawable.dnif;
        daftarImage[13]=R.drawable.explosif;

        respect = (ImageView) v.findViewById(R.id.imageViewRespect);
        himaLine = (ImageView) v.findViewById(R.id.imageViewLine);
        himaInsta = (ImageView) v.findViewById(R.id.imageViewInstagram);
        himaFb = (ImageView) v.findViewById(R.id.imageViewFacebook);
        himaTwitter = (ImageView) v.findViewById(R.id.imageViewTwitter);
        kontent = (ImageView) v.findViewById(R.id.imageViewKontent);
        fifa = (ImageView) v.findViewById(R.id.imageViewFIFA);
        ifbf = (ImageView) v.findViewById(R.id.imageViewIFBF);
        pbif = (ImageView) v.findViewById(R.id.imageViewpbif);
        mibHimaif = (ImageView) v.findViewById(R.id.imageViewMib);
        fortran = (ImageView) v.findViewById(R.id.imageViewFortran);
        pandaif = (ImageView) v.findViewById(R.id.imageViewPanda);
        dnif = (ImageView) v.findViewById(R.id.imageViewDNIF);
        explosif = (ImageView) v.findViewById(R.id.imageViewExplosIF);

        judul = (TextView) v.findViewById(R.id.textViewjudul);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/remachinescript.ttf");
        judul.setTypeface(tf);

        himaLine.setOnClickListener(this);
        himaInsta.setOnClickListener(this);
        himaFb.setOnClickListener(this);
        himaTwitter.setOnClickListener(this);
        kontent.setOnClickListener(this);
        fifa.setOnClickListener(this);
        ifbf.setOnClickListener(this);
        pbif.setOnClickListener(this);
        mibHimaif.setOnClickListener(this);
        fortran.setOnClickListener(this);
        pandaif.setOnClickListener(this);
        dnif.setOnClickListener(this);
        explosif.setOnClickListener(this);

        Picasso.with(Portofolio.this.getContext()).load(daftarImage[0]).into(respect);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[1]).into(himaLine);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[2]).into(himaInsta);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[3]).into(himaFb);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[4]).into(himaTwitter);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[5]).into(kontent);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[6]).into(fifa);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[7]).into(ifbf);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[8]).into(pbif);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[9]).into(mibHimaif);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[1]).into(fortran);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[11]).into(pandaif);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[12]).into(dnif);
        Picasso.with(Portofolio.this.getContext()).load(daftarImage[13]).into(explosif);


        return v;
    }


    @Override
    public void onClick(View v) {
        int num = v.getId();
        Uri uri;
        Intent intent;
        switch (num){
            case R.id.imageViewLine:
                uri = Uri.parse("http://line.me/ti/p/%40xqa3540r"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewInstagram:
                uri = Uri.parse("https://www.instagram.com/himaiftelkom/"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewFacebook:
                uri = Uri.parse("https://www.facebook.com/groups/120932371307454/"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewTwitter:
                uri = Uri.parse("https://twitter.com/himaiftelkom?lang=en"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewKontent:
                uri = Uri.parse("http://line.me/ti/p/%40fns2717v"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewFIFA:
                uri = Uri.parse("http://line.me/ti/p/%40tnv4574a"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewIFBF:
                uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewpbif:
                uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewMib:
                uri = Uri.parse("http://line.me/ti/p/%40uzo0610j"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewFortran:
                uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewPanda:
                uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewDNIF:
                uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.imageViewExplosIF:
                uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
        }
    }
}
