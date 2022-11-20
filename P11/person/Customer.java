package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class Customer extends Person{
    
    public Customer(String name, String phone) {
        super(name, phone);
    }

    public Customer(BufferedReader in) throws IOException {
        super(in);
    }

    public void save(BufferedWriter out) throws IOException {
        super.save(out);
    }

    @Override
    public boolean equals(Object rhs) {
        if (rhs == this)
            return true;
        if (rhs == null)
            return false;
        if (rhs.getClass() != this.getClass())
            return false;
        Customer b = (Customer) rhs;
        return (b.name.equals(this.name)) && (b.phone.equals(this.phone));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}