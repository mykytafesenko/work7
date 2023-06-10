// PaintActivity.java
package com.example.labwork7;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class PaintActivity extends AppCompatActivity {

    static final int MENU_COLOR_WHITE = Menu.FIRST + 1;
    static final int MENU_NEW_IMAGE = Menu.FIRST + 2;
    static final int MENU_SAVE = Menu.FIRST + 3;
    PaintView paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        paintView = new PaintView(this);
        setContentView(paintView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, MENU_COLOR_WHITE, Menu.NONE, "Erase");
        menu.add(Menu.NONE, MENU_NEW_IMAGE, Menu.NONE, "Clear");
        menu.add(Menu.NONE, MENU_SAVE, Menu.NONE, "Save");
        return true;
    }
    // реалізація пунктів контекстного меню
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // вибір білого кольору та широкого пензля
            // для того щоб імітувати роботу ластика
            case MENU_COLOR_WHITE:
                paintView.set_line_color(Color.WHITE);
                paintView.set_line_width(70);
                Toast.makeText(this, "Eraser picked.", Toast.LENGTH_SHORT).show();
                return true;
            // очищення холсту
            case MENU_NEW_IMAGE:
                paintView.clear();
                Toast.makeText(this, "Сanvas cleaned.", Toast.LENGTH_SHORT).show();
                return true;
            // збереження малюнку в пам'ять пристрою
            case MENU_SAVE:
                paintView.save_image();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}