package ss19.bai_tap.class_validate;

public class NameClassCheck {
    public static NameClass nameClass = new NameClass();
    public static final String[] validClass = new String[]{"C0223G", "A0323K"};
    public static final String[] invalidClass = new String[]{"C_06D12", "M0318G","P0323A"};

    public static void main(String[] args) {
        nameClass=new NameClass();
        for(String name:validClass){
            boolean isValid= nameClass.validate(name);
            System.out.println("Class name:"+name+" isValid:"+isValid);
        }
        for(String name:invalidClass){
            boolean isValid= nameClass.validate(name);
            System.out.println("Class name:"+name+" isValid:"+isValid);
        }
    }
}
