package com.bootstrap.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootstrap.models.entities.Product;
import com.bootstrap.models.repositories.Productrepository;

@Service
public class ProductService {
   
   @Autowired
   private Productrepository productrepository;

   @Autowired
   private EmailSenderService emailSender;

   public List<Product> findAllProduct(){
      return productrepository.findAll();
   }

   public void save(Product product){
      productrepository.save(product);
      this.emailSender.emailSender("cibakutense@gmail.com", "new product has added", "lithan oh lithan");
   }

   public List<Product> findBynameEqual(String name) {
      return productrepository.findByNameContains(name);
   }

   public void deleteOne(long id){
      productrepository.deleteById(id);
   }

   public Optional<Product> findbyId(long id) {
      return productrepository.findById(id);
   }

}
