package com.android.example.androiddeveloper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_business_address)
    TextView mBusinessAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSpannableString();
    }

    @OnClick(R.id.text_business_address)
    public void openLocationInMap() {
        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + mBusinessAddress.getText().toString())
        );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void setSpannableString() {
        SpannableString spannableString = new SpannableString(getString(R.string.business_address));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        mBusinessAddress.setText(spannableString);
    }
}
