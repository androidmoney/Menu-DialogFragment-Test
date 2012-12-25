package com.example.menudialogtest;


import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends Activity
{
    private static final int MENU_ITEM_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ViewGroup frame = new FrameLayout(this);
        frame.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        TextView button = new Button(this);
        button.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        button.setText("Show Dialog");
        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showDialogFragment();
            }
        });

        frame.addView(button);
        setContentView(frame);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuItem item = menu.add(0, MENU_ITEM_ID, 0, "Show dialog");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        boolean consumed = false;

        if (menuItem.getItemId() == MENU_ITEM_ID)
        {
            showDialogFragment();
            consumed = true;
        }

        return consumed;
    }


    void showDialogFragment()
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(new MyDialogFragment(), "tag");
        transaction.commit();
    }


    public static class MyDialogFragment extends DialogFragment
    {
        @Override
        public Dialog onCreateDialog(Bundle state)
        {
            Builder builder = new Builder(getActivity());
            builder.setTitle("Dialog Fragment");
            builder.setMessage("Dialog message");

            return builder.create();
        }
    }
}
