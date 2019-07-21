package com.baipu.project;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.baipu.project.custom.SpecialTab;
import com.baipu.project.custom.SpecialTabRound;
import com.baipu.project.utils.BottomNavigationUtils;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends AppCompatActivity {
    private NavController mNavController;
    private final int[] PAGE_IDS = {
            R.id.HomeFragment,
            R.id.CategoryFragment,
            R.id.PlusFragment,
            R.id.MessageFragment,
            R.id.AccountFragment,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HideAllBar();
        PageNavigationView tab = findViewById(R.id.tab);
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationController navigationController = tab.custom()
                .addItem(newItem(R.drawable.bottom_home, R.drawable.bottom_home_selected,getString(R.string.home)))
                .addItem(newItem(R.drawable.bottom_category, R.drawable.bottom_category_selected, getString(R.string.category)))
                .addItem(newRoundItem(R.drawable.iconsplus, R.drawable.iconsplus, getString(R.string.midplus)))
                .addItem(newItem(R.drawable.bottom_message, R.drawable.bottom_message_selected, getString(R.string.message)))
                .addItem(newItem(R.drawable.bottom_account, R.drawable.bottom_account_selected, getString(R.string.account)))
                .build();
        //自动适配ViewPager页面切换
//        navigationController.setupWithViewPager(viewPager);

        //设置消息数
//        navigationController.setMessageNumber(1, 8);
//
//        //设置显示小圆点
//        navigationController.setHasMessage(0, true);
        BottomNavigationUtils.setupWithNavController(PAGE_IDS, navigationController, mNavController);
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                if(index==2)
                {

                }
                Log.i("asd", "selected: " + index + " old: " + old);
            }

            @Override
            public void onRepeat(int index) {
                //重复选中时触发
            }
        });

    }
    //创建一个Item
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text){
        SpecialTab mainTab = new SpecialTab(this);
        mainTab.initialize(drawable,checkedDrawable,text);
        mainTab.setTextDefaultColor(0xFF888888);
        mainTab.setTextCheckedColor(0xFF009688);
        return mainTab;
    }
    private BaseTabItem newRoundItem(int drawable,int checkedDrawable,String text){
        SpecialTabRound mainTab = new SpecialTabRound(this);
        mainTab.initialize(drawable,checkedDrawable,text);
        mainTab.setTextDefaultColor(0xFF888888);
        mainTab.setTextCheckedColor(0xFF009688);
        return mainTab;
    }
    private void HideAllBar()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        else if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

}
