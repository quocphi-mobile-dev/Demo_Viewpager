package com.example.demo_viewpager.home_screen.interf;
public interface ItemTouchListenner {
    void onMove(int oldPosition, int newPosition);
    void swipe(int position, int direction);
}
