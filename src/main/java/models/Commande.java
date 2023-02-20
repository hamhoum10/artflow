package models;

import services.CommandeService;

public class Commande {
        //Player p =new Player();

        private int id;
        //baed twali p.getcustomerID()
        //private int customerId =3; //3 just pour tester ba3ed twali ki fama auth ytemlé el variable (forcit client b customer_id =3 fi bd heka wa3leh attribut = 3 mesh ybda andi acces al row te3o)

        private int id_panier; //baed twali panier
        private String status;
        private double totalAmount;
        private String createdAt;
        private int codepostal;
        private String adresse;


    // Constructeur pour établir une connexion à la base de données
        public Commande() {

        }


    public Commande(int id_panier, String status, double totalAmount, String createdAt, int codepostal, String adresse) {
        this.id_panier=id_panier;
        this.status = status;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
        this.codepostal = codepostal;
        this.adresse = adresse;
    }

        // Getters pour les variables d'instance
        public int getId() {
            return id;
        }

        public int getId_panier() {
        return id_panier;
        }
            public void setId_panier(int id_panier) {
            this.id_panier = id_panier;
        }

        public String getStatus() {
            return status;
        }

        public double getTotalAmount() {
            //direct ta3mel calcule mta prix total w t7oto fi attribut Totalamount mta class Orders (commande) eli mesh ytaficha fi db ki ta3mel creat() eli fi OrderService
            CommandeService os = new CommandeService();
            //double tm = os.totalmontantCommande(customerId);
            //setTotalAmount(tm);

            return totalAmount;
        }

        public String getCreatedAt() {
            return createdAt;
        }

    public int getCodepostal() {
        return codepostal;
    }


    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }



    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }*/

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", id_panier=" + id_panier +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", createdAt='" + createdAt + '\'' +
                ", codepostal=" + codepostal +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}


