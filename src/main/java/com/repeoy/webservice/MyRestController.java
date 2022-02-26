package com.repeoy.webservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class MyRestController {

    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    @GetMapping("home")
    public String home(){
        return "Welcome to the webpage!";
    }

    /**
     * Palauttaa yhden product-olion, jonka spring palauttaa
     * kutsujalle JSON muodossa:
     *      {
     *          "name": "Acer Laptop",
     *          "price": "800"
     *      }
     */
    @GetMapping("product")
    public Product getProduct(){
        return new Product("Acer Laptop", 800);
    }

    /**
     * Palauttaa kutsujalle listan tuotteita, joka muutetaan
     * kutsujalle JSON-muotoon:
     *  [
     *      {
     *          "name": "GoPro",
     *          "price": "200"
     *      },
     *      {
     *          "name": "PS4",
     *          "price": "380"
     *      },
     *  ]
     */
    @GetMapping("products")
    public List<Product> getProducts(){
        return List.of(
                new Product("GoPro", 200),
                new Product("PS4", 380)
        );
    }

    /**
     * Ottaa vastaan luvun polkuparametina esim. /num/34
     * ja tulostaa sen palvelimen konsoliin
     */
    @GetMapping("num/{luku}")
    public String getLuku( @PathVariable String luku ){
        System.out.println(luku);
        return "";
    }

    /**
     * Ottaa vastaan kaksi lukua polkuparametreina esim. /sum/3/5
     * ja palauttaa merkkijonona lukujen summan.
     */
    @GetMapping("sum/{num1}/{num2}")
    public String calcSum(@PathVariable int num1, @PathVariable int num2 ){
        Integer sum = num1+num2;
        return sum.toString();
    }

    /**
     * Ottaa vastaan osoitteesta /summa kaksi query parametria POST-komennolla
     * ja palauttaa lukujen summan tekstinä kutsujalle.
     */
    @PostMapping("summa")
    public String calcMySum(@RequestParam int x, @RequestParam int y){
        Integer sum = x + y;
        return "Lukujen summa on " + sum;
    }

    @GetMapping("size")
    public Map<String, String> getDimensions(@RequestBody Map<String, String> json ){
        String width = json.get("width");
        String height = json.get("height");

        return Map.of(
                "width", width,
                "height", height);
    }








// tasta eteenpain omaa koodia


    @PostMapping("addstudent")
    public List<Student> addStudent(@RequestParam String fName,
                                    @RequestParam String lName,
                                    @RequestParam int number,
                                    @RequestParam String address,
                                    @RequestParam int opiskelijaID){
        Student e = new Student(fName,lName,number, address, opiskelijaID);
        students.add(e);
        return getStudents();
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }


    @PostMapping("addcourse")
    public String addCourse(@RequestParam String courseName,
                            @RequestParam String teacher,
                            @RequestParam int grade,
                            @RequestParam int kurssiID
                            ){
        Course e = new Course(courseName, teacher, grade, kurssiID);
        courses.add(e);
        return "kurssi" +courseName+ "lisätty";
    }

    @PostMapping("studentToCourse")
    public String studentToCourse(@RequestParam int kurssiID,
                            @RequestParam int opiskleijaID
    ){

        Course e = new Course(courseName, teacher, grade, kurssiID);
        courses.add(e);
        return "kurssi  lisätty";
    }

    @GetMapping("courses")
    public List<Course> getCourses(){
        return courses;
    }

    @PostMapping("addtocourse")
    public String addtocourse (@RequestParam int KurssiID,
                               @RequestParam int opiskelijaID
    )
    {
        ////////////////tahan jotain

    }




    @GetMapping("ilmoitttautumiset")
    public List<AddToCourse> getAddToCourse(){
        if
    }

}





    