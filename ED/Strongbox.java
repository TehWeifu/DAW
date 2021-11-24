import java.util.ArrayList;

public class Strongbox {
    final private String material;
    private int password;
    private boolean open;
    private ArrayList<String> storage;

    public Strongbox(String material) {
        this(material, 0, true, new ArrayList<>());
    }

    public Strongbox(String material, ArrayList<String> storage) {
        this(material, 0, true, storage);
    }

    private Strongbox(String material, int password, ArrayList<String> storage) {
        this(material, password, true, storage);
    }

    private Strongbox(String material, int password, boolean open, ArrayList<String> storage) {
        this.material = material;
        this.password = password;
        this.open = open;
        this.storage = storage;
    }

    public String getMaterial() {
        return this.material;
    }

    public Strongbox setPassword(final int oldPass, final int newPass) {
        if (this.password == oldPass) {
            this.password = newPass;
        }
        return this;
    }

    public Strongbox openBox(final int numPass) {
        if (numPass == password) {
            this.open = true;
        }
        return this;
    }

    public Strongbox closeBox() {
        this.open = false;
        return this;
    }

    public boolean saveItem(String str) {
        if (open) {
            this.storage.add(str);
            return true;
        }
        return false;
    }

    public boolean retrieveItem(String str) {
        if (open) {
            if (this.storage.contains(str)) {
                this.storage.remove(str);
                return true;
            } else return false;
        } else {
            return false;
        }
    }
}
