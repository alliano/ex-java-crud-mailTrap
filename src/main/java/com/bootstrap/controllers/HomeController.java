package com.bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootstrap.dto.SearchDto;
import com.bootstrap.models.entities.Product;
import com.bootstrap.services.ProductService;


@Controller

@RequestMapping(path = "/")

public class HomeController {

   private final String header = "sepering-buut: JEMBUT";

   @Autowired
   private ProductService productService;

   @GetMapping
   public String home(Model model){

      model.addAttribute("title","home");

      model.addAttribute("header", this.header);

      model.addAttribute("search", new SearchDto());

      model.addAttribute("products", productService.findAllProduct());

      return "index";
   }

   @GetMapping(path = "/insert")
   public String insert(Model model, Product prosuct) {

      model.addAttribute("header", this.header);

      model.addAttribute("title","insert");

      return "insert";
   }

   @PostMapping(path = "/save")
   public String save(Product product, Model model){

      model.addAttribute("header", this.header);

      this.productService.save(product);

      model.addAttribute("products", this.productService.findAllProduct());

      return "redirect:/";
   }

   @GetMapping(path = "/edit/{id}")
   public String edit(@PathVariable("id") int id, Model model) {
      
      model.addAttribute("product", productService.findbyId(id));

      model.addAttribute("header", this.header);

      return "edit";
   }

   @GetMapping(path = "/delete/{id}")
   public String delete(@PathVariable("id") long id){

      productService.deleteOne(id);

      return "redirect:/";
   }

   @PostMapping(path = "/update")
   public String update(Product product){

      productService.save(product);

      return "redirect:/";
   }

   @PostMapping(path = "/search")
   public String search(SearchDto search, Model model){

      model.addAttribute("title","search");

      model.addAttribute("header", this.header);

      model.addAttribute("search", search);
      
      model.addAttribute("products", productService.findBynameEqual(search.getKeyWord()));

      return "index";
   }
   
}
