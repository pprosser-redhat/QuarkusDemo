package io.quarkus.workshop.super_heroes_client;

public class Hello {
    
    public Hello(String hello) {
        this.hello = hello;
    }

    String hello;
    
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }


}
