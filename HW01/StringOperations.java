// HW01
public class StringOperations {
    public static void main (String[] args){
        String name = "Colin"; // declare name variable
        System.out.println(name); // print name variable
        name = "A" + name.substring(1); // change first character to "A"
        name = name.substring(0, 4) + "Z"; // change last character to "Z"
        System.out.println(name); // print out new name
        String website = "www.stackoverflow.com"; // declare website
        System.out.println(website); // print website
        website = website.substring(4, website.length() - 4) + "1331"; // take substring of name and append 1331
        System.out.println(website); // print new website
    }
}