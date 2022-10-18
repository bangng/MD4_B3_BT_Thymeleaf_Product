package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rikkei.academy.model.Product;
import rikkei.academy.service.IProductService;
import rikkei.academy.service.ProductServiceIMPL;

@Controller
@RequestMapping(value = {"/", "/product"})
public class ProductController {
    private final IProductService productService = new ProductServiceIMPL();

    @GetMapping
    public String viewIndex(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String upDate(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("Success", "Removed customer successfully!");
        return "redirect:/product";
    }

}
