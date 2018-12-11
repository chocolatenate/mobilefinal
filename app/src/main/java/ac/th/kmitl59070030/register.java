package ac.th.kmitl59070030;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class register extends Fragment {
    private SQLiteDatabase database;
    private ContentValues cv;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final EditText userid = getView().findViewById(R.id.user_id);


        Button regis_butn = getView().findViewById(R.id.regis_bnt);
        regis_butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = getView().findViewById(R.id.name);
                EditText age = getView().findViewById(R.id.age);
                EditText pass = getView().findViewById(R.id.pass);
                String userid_str = userid.getText().toString();
                String name_str = name.getText().toString();
                String pass_str = pass.getText().toString();
                String age_str = age.getText().toString();
                int age_int = Integer.parseInt(age.getText().toString());
                if(userid_str.length()>=6 && userid_str.length()<=12 && name_str.split( " ").length==2 && age_int>=10 && age_int <=80 && pass_str.length()>=6){
                    database = getActivity().openOrCreateDatabase("nate.final", Context.MODE_PRIVATE,null);
                    database.execSQL(
                            "CREATE TABLE IF NOT EXISTS db (id INTEGER PRIMARY KEY AUTOINCREMENT,user_id VARCHAR(12),name VARCHA, age VARCHAR(2),password VARCHAR(6)) "
                    );
                    regis regis_add = new regis();
                    regis_add.setCv(userid_str,name_str,age_str,pass_str);
                    cv = regis_add.getCv();

                    database.insert("db",null,cv);
                }
            }
        });

    }
}
