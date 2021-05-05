package com.example.navdrawer.ui.contacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navdrawer.R;
import com.example.navdrawer.ui.ContactUsActivity;
import com.example.navdrawer.ui.SendEmail;

import java.util.Calendar;

public class ContactsFragment extends Fragment {

    Button  btnAboutus;
    TextView    copyright;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contacts, container, false);

        RelativeLayout btnInsta = v.findViewById(R.id.imagebtn_insta);
        RelativeLayout btnTwitter = v.findViewById(R.id.imagebtn_twitter);
        RelativeLayout btnEmail = v.findViewById(R.id.imagebtn_email);

        //btnEmail = v.findViewById(R.id.btnEmail);
        btnAboutus = v.findViewById(R.id.btnAboutus);
        copyright = v.findViewById(R.id.copyright);
        //btnInsta = v.findViewById(R.id.btnInsta);
        //btnTwitter = v.findViewById(R.id.btnTwitter);

        final String copyrightString = String.format("Copyright %d by Group 3", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setText(copyrightString);
        copyright.setGravity(Gravity.CENTER);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SendEmail.class);
                startActivity(intent);
            }
        });

        btnAboutus.setOnClickListener(v12 -> {
            Intent intent2 = new Intent(getActivity(), ContactUsActivity.class);
            startActivity(intent2);
        });

        btnInsta.setOnClickListener(v1 -> goToURL("https://instagram.com/marquette_bmes?igshid=1efcrebyd4bs4"));
        btnTwitter.setOnClickListener(new View.OnClickListener()    {
            @Override
            public void onClick(View v) {
                goToURL("https://twitter.com/mu_bmes?s=21");
            }
        });
        return v;
    }

    private void goToURL(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
