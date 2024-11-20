package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count() == 0) {
            InhousePart grndBeef = new InhousePart();
            grndBeef.setName("Beef");
            grndBeef.setInv(30);
            grndBeef.setPrice(4.99);
            grndBeef.setId(1);

            partRepository.save(grndBeef);

            InhousePart tacoSeasoning = new InhousePart();
            tacoSeasoning.setName("Taco Seasoning");
            tacoSeasoning.setInv(30);
            tacoSeasoning.setPrice(2.49);
            tacoSeasoning.setId(2);

            partRepository.save(tacoSeasoning);

            InhousePart tomatoRoma = new InhousePart();
            tomatoRoma.setName("Tomato Roma");
            tomatoRoma.setInv(30);
            tomatoRoma.setPrice(0.79);
            tomatoRoma.setId(3);

            partRepository.save(tomatoRoma);

            InhousePart sourCream = new InhousePart();
            sourCream.setName("Sour Cream");
            sourCream.setInv(30);
            sourCream.setPrice(2.79);
            sourCream.setId(4);

            partRepository.save(sourCream);

            InhousePart shrdCheese = new InhousePart();
            shrdCheese.setName("Shredded Cheese");
            shrdCheese.setInv(30);
            shrdCheese.setPrice(3.79);
            shrdCheese.setId(5);

            partRepository.save(shrdCheese);

            // Spaghetti Ingredients
            InhousePart noodles = new InhousePart();
            noodles.setName("Noodles");
            noodles.setInv(30);
            noodles.setPrice(1.49);
            noodles.setId(6);

            partRepository.save(noodles);

            InhousePart marinara = new InhousePart();
            marinara.setName("Marinara Sauce");
            marinara.setInv(30);
            marinara.setPrice(3.79);
            marinara.setId(7);

            partRepository.save(marinara);

            InhousePart italianSeasoning = new InhousePart();
            italianSeasoning.setName("Italian Seasoning");
            italianSeasoning.setInv(30);
            italianSeasoning.setPrice(1.79);
            italianSeasoning.setId(8);

            partRepository.save(italianSeasoning);

            InhousePart parmesean = new InhousePart();
            parmesean.setName("Parmesean");
            parmesean.setInv(30);
            parmesean.setPrice(3.79);
            parmesean.setId(9);

            partRepository.save(parmesean);

            // Baked Potato Bar Ingredients
            InhousePart russet = new InhousePart();
            russet.setName("Russet");
            russet.setInv(30);
            russet.setPrice(1.79);
            russet.setId(10);

            partRepository.save(russet);

            // Sausage, Egg & Cheese Sandwich Ingredients
            InhousePart americanCheese = new InhousePart();
            americanCheese.setName("American Cheese");
            americanCheese.setInv(30);
            americanCheese.setPrice(4.79);
            americanCheese.setId(12);

            partRepository.save(americanCheese);

            InhousePart eggs = new InhousePart();
            eggs.setName("Dozen Eggs");
            eggs.setInv(30);
            eggs.setPrice(2.79);
            eggs.setId(14);

            partRepository.save(eggs);

            InhousePart engMuff = new InhousePart();
            engMuff.setName("English Muffins");
            engMuff.setInv(30);
            engMuff.setPrice(3.79);
            engMuff.setId(15);

            partRepository.save(engMuff);

            // Beef Alfredo
            InhousePart alfredo = new InhousePart();
            alfredo.setName("Alfredo Sauce");
            alfredo.setInv(30);
            alfredo.setPrice(3.79);
            alfredo.setId(16);

            partRepository.save(alfredo);

            InhousePart greenBeans = new InhousePart();
            greenBeans.setName("Green Beans");
            greenBeans.setInv(30);
            greenBeans.setPrice(1.79);
            greenBeans.setId(17);

            partRepository.save(greenBeans);
        }

        if (productRepository.count() == 0) {
            Product beefTacos = new Product("Beef Tacos", 9.99, 30);
            productRepository.save(beefTacos);

            Product spaghetti = new Product("Spaghetti", 9.99, 30);
            productRepository.save(spaghetti);

            Product potatoBar = new Product("Potato Bar", 9.99, 30);
            productRepository.save(potatoBar);

            Product ssgEggChsSand = new Product("Sausage, Egg & Cheese Sandwich", 9.99, 30);
            productRepository.save(ssgEggChsSand);

            Product beefAlfredo = new Product("Beef Alfredo", 9.99, 30);
            productRepository.save(beefAlfredo);
        }

        //Logging Bootsrap Data Information
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
