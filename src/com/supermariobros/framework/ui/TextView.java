package com.supermariobros.framework.ui;

import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;

import java.io.File;
import java.io.IOException;

public class TextView extends View implements Drawable {
    private String text;
    private Text textView;
    private Font font;

    public TextView(String text) {
        try {
            this.font = new Font();
            this.font.loadFromFile(new File("assets/fonts/Roboto-Regular.ttf").toPath());
            this.text = text;
            textView = new Text();
            textView.setString(this.text);
            textView.setFont(this.font);
            textView.setPosition(new Vector2f(0, 0));
            textView.setColor(Color.RED);
            textView.setCharacterSize(14);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(RenderTarget renderTarget, RenderStates renderStates) {
        renderTarget.draw(textView);
    }
}
