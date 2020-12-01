public class ContactItem {
    String first;
    String last;
    String phone;
    String email;

    public ContactItem(String first, String last, String phone, String email) throws IllegalArgumentException {
        if(first.isEmpty() && last.isEmpty() && phone.isEmpty() && email.isEmpty()){
            throw new IllegalArgumentException("cannot leave all fields empty");
        } else {
            if(!(first.isEmpty()))setFirst(first);
            if(!(last.isEmpty()))setLast(last);
            if(!(phone.isEmpty()))setPhone(phone);
            if(!(email.isEmpty()))setEmail(email);
        }
    }

    public ContactItem(){}

    public void setFirst(String first) throws IllegalArgumentException {
        if(first.length() >= 1){
            this.first = first;
        } else {
            throw new IllegalArgumentException("must be at least one character in length");
        }
    }

    public void setLast(String last) throws IllegalArgumentException {
        if(last.length() >= 1){
            this.last = last;
        } else {
            throw new IllegalArgumentException("must be at least one character in length");
        }
    }

    public void setPhone(String phone) throws IllegalArgumentException {
        if(phone.matches("([0-9]{3})-([0-9]{3})-([0-9]{4})")){
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("must be format (xxx-xxx-xxxx)");
        }
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")){
            this.email = email;
        } else {
            throw new IllegalArgumentException("must be format (x@y.z)");
        }
    }

    public void Edit(String first, String last, String phone, String email) throws IllegalArgumentException {
        if(first.isEmpty() && last.isEmpty() && phone.isEmpty() && email.isEmpty()){
            throw new IllegalArgumentException("cannot leave all fields empty");
        } else {
            if(!(first.isEmpty()))this.setFirst(first);
            if(!(last.isEmpty()))this.setLast(last);
            if(!(phone.isEmpty()))this.setPhone(phone);
            if(!(email.isEmpty()))this.setEmail(email);
        }
    }
}
