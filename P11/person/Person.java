package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class Person {

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Person(BufferedReader in) throws IOException {
        this.name = in.readLine();
        this.phone = in.readLine();
    }

    public void save(BufferedWriter out) throws IOException {
        out.write(this.name);
        out.write(this.phone);
    }

    @Override
    public String toString() {
        return "Name : " + name + " Phone : " + phone;
    }

    @Override
    public boolean equals(Object rhs) {
        if (rhs == this)
            return true;
        if (rhs == null)
            return false;
        if (rhs.getClass() != this.getClass())
            return false;
        Person b = (Person) rhs;
        return (b.name.equals(this.name)) && (b.phone.equals(this.phone));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }

    protected String name;
    protected String phone;
}