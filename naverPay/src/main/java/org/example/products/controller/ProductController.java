package org.example.products.controller;

import org.example.shopping.entity.Product;
import org.example.products.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/naver")
public class ProductController {

    ProductService productService;

    @GetMapping("/pay")
    public String pay(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        return "호출할 view";
    }

    @GetMapping("/getalllist")
    public String getAllList(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        int pId = (Integer) session.getAttribute("pId");
        List<Product> productList = productService.getAllList(Integer.parseInt("pId"));

        model.addAttribute("list", productList);
        System.out.println(pId);

        return "VIEW 이름";
    }



} // class 마지막
