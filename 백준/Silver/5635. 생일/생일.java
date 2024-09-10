import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Person maxAgePerson = null;
        Person minAgePerson = null;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            Person person  = new Person(name, year, month, day);
            if(maxAgePerson == null) {
                maxAgePerson = person;
            }
            if(minAgePerson == null) {
                minAgePerson = person;
            }

            if(maxAgePerson.compareTo(person) > 0) {
                maxAgePerson = person;
            }
            if(minAgePerson.compareTo(person) < 0) {
                minAgePerson = person;
            }
        }
        System.out.println(minAgePerson.name + '\n' + maxAgePerson.name);
    }

    static class Person implements Comparable<Person> {
        String name;
        int year;
        int month;
        int day;

        public Person(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo(Person person) {
            if(this.year != person.year) {
                return this.year - person.year;
            }
            if(this.month != person.month) {
                return  this.month - person.month;
            }
            return this.day - person.day;
        }
    }
}