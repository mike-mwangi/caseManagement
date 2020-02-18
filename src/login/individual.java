package login;

import java.util.Objects;

public class individual {

    public class Person {


        private String email;
        private String password;
        private String name;

        private String role;


        public Person(String email) {
            this.email = email;
        }

        public Person(String email, String password, String name, String role) {
            this.email = email;
            this.password = password;
            this.name = name;
            this.role = role;
        }


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(email, person.email) &&
                    Objects.equals(password, person.password) &&
                    Objects.equals(name, person.name) &&
                    Objects.equals(role, person.role);
        }

        @Override
        public int hashCode() {
            return Objects.hash(email, password, name, role);
        }
    }
}
