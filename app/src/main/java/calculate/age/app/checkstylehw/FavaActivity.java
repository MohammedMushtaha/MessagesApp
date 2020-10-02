package calculate.age.app.checkstylehw;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bicycle.jokesapp.Adapter.AdapterAllMsg;
import com.bicycle.jokesapp.Model.Msg;
import com.bicycle.jokesapp.SQLite.DBAdapter;

import java.util.ArrayList;

public class FavaActivity extends AppCompatActivity {
  private RecyclerView productsrecyclerview;
  ArrayList<Msg> items = new ArrayList<>();
  DBAdapter db;
  AdapterAllMsg adapter;


  @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fava);
    db = new DBAdapter(FavaActivity.this);
    items = db.get_ShoppingCart_products();
    if (items.size() > 0) {
      productsrecyclerview = (RecyclerView) findViewById(R.id.shoppingcart_recyclerView);
      productsrecyclerview.setHasFixedSize(true);
      productsrecyclerview.setItemViewCacheSize(20);
      productsrecyclerview.setDrawingCacheEnabled(true);
      productsrecyclerview.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
      productsrecyclerview.setLayoutManager(new LinearLayoutManager(FavaActivity.this));
      adapter = new AdapterAllMsg(FavaActivity.this, items);
      productsrecyclerview.setAdapter(adapter);
    } else {
      Toast.makeText(FavaActivity.this, "لا يوجد مسجات في المفضلة",
      Toast.LENGTH_SHORT).show();

    }
    //        search_icon.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //                close.setVisibility(VISIBLE);
    //                search.setVisibility(VISIBLE);
    //                search_icon.setVisibility(View.GONE);
    ////                CloseKeyboard();
    //
    //            }
    //        });
    //        close.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //                close.setVisibility(View.GONE);
    //                search.setVisibility(View.GONE);
    //                search_icon.setVisibility(VISIBLE);
    //                search.setText("");
    ////                OpenKeyboard();
    //            }
    //        });
    //        search.addTextChangedListener(new TextWatcher() {
    //            @Override
    //            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    //
    //            }
    //
    //            @Override
    //            public void onTextChanged(CharSequence s, int start, int before, int count) {
    //
    //            }
    //
    //            @Override
    //            public void afterTextChanged(Editable s) {
    //                filter(s.toString());
    //            }
    //        });


  }

  //    public void filter(String text) {
  //        ArrayList<Msg> filtermissonList = new ArrayList<>();
  //        for (Msg item : items) {
  //            if (item.getMESSAGE().toLowerCase().contains(text.toLowerCase())) {
  //                filtermissonList.add(item);
  //            }
  //        }
  //        adapter.filterList(filtermissonList);
  //    }
}