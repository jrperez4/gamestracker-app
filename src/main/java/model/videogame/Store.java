package model.videogame;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Store {
    private StoreInfo store;

    public Store() {

    }

    public StoreInfo getStore() {
        return store;
    }

    public void setStore(StoreInfo store) {
        this.store = store;
    }
}
