public class Estanteria {
    private Publicacio[] estanteria;

//    public Estanteria(final Publicacio[] estanteria) {
//        this.estanteria = estanteria;
//    }

    public Estanteria() {
        this.estanteria = new Publicacio[10];
    }

    public String getEstanteria() {
        String st = "";
        for (int i = 0; i < estanteria.length; i++) {
            if (estanteria[i] != null) {
                st += estanteria[i] + "\n\n";
            }
        }
        return st;
    }

    public void addEstanteria(Publicacio publi) {
        for (int i = 0; i < estanteria.length; i++) {
            if (estanteria[i] == null) {
                estanteria[i] = publi;
                return;
            }
        }
    }

    public Publicacio findPublicacioPorCodi(final int codi) {
        for (Publicacio publicacio : estanteria) {
            if (publicacio.getCodi() == codi) {
                return publicacio;
            }
        }
        return null;
    }
}
