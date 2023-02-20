package models;

public class Panier {
    private int id_panier;
    private int id_client; //change it into Customer class

    private Client client;

    public Panier(){}
    public Panier(int id_client) {
        this.id_client = id_client;
    }

    public Panier(int id_client, Client client) {
        this.id_client = id_client;
        this.client = client;
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getId_client() {
        return id_client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "id_panier=" + id_panier +
                ", id_client=" + id_client +
                ", client=" + client +
                '}';
    }
}
