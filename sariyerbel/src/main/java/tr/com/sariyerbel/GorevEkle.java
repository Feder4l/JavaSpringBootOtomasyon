package tr.com.sariyerbel;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/gorev")
public class GorevEkle {

    public record Gorev(String ad, String numara) {};

    static final List<Gorev> GOREV_LISTESI = new ArrayList<>();
   
    @GetMapping("/")
    public List<Gorev> listele(){
        return GOREV_LISTESI;
    }
   
    @GetMapping("/{no}")
    public Gorev bul(@PathVariable String no){
        for(Gorev gorev: GOREV_LISTESI) {
            if(gorev.numara().equals(no)) {
                return gorev;
            }
        }
        return null;
    }
   
   
    @PostMapping("/")
    public Gorev ekle(@RequestBody Gorev gorev) {
    	GOREV_LISTESI.add(gorev);
        return gorev;
    }
}