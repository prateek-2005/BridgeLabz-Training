package resumescreeningsystem;
public class ProductManager extends JobRole {
    public ProductManager(String name) {
        super(name);
    }
    @Override
    public void screen() {
        System.out.println(getCandidateName() + " screened for Product Strategy, Communication, Analytics.");
    }
}

