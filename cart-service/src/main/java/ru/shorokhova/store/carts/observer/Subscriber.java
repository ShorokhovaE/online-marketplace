package ru.shorokhova.store.carts.observer;

import org.springframework.stereotype.Component;

@Component
public class Subscriber implements Observer {

    @Override
    public void handleEvent(String msq) {
        System.out.println(msq);
    }
}
