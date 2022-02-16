package com.repeoy.webservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MyRestController {

    List<Exam> exams = new ArrayList<>();

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

    @PostMapping("addexam")
    public String addExam(@RequestParam String subject, @RequestParam String grade){
        Exam e = new Exam(subject,grade);
        exams.add(e);
        return "Kurssi lisätty";
    }

    @GetMapping("exams")
    public List<Exam> getExams(){
        return exams;
    }

}
