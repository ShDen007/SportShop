package org.itstep.SportShop.controllers;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.itstep.SportShop.dao.OrderDAO;
import org.itstep.SportShop.dao.ProductDAO;
import org.itstep.SportShop.entity.Product;
import org.itstep.SportShop.form.ProductForm;
import org.itstep.SportShop.model.OrderDetailInfo;
import org.itstep.SportShop.model.OrderInfo;
import org.itstep.SportShop.pagination.PaginationResult;
import org.itstep.SportShop.validator.ProductFormValidator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@EnableAutoConfiguration
@Controller
@Transactional
public class AdminController {

    private final OrderDAO orderDAO;

    private final ProductDAO productDAO;

    private final ProductFormValidator productFormValidator;

    public AdminController(OrderDAO orderDAO, ProductDAO productDAO, ProductFormValidator productFormValidator) {
        this.orderDAO = orderDAO;
        this.productDAO = productDAO;
        this.productFormValidator = productFormValidator;
    }

    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == ProductForm.class) {
            dataBinder.setValidator(productFormValidator);
        }
    }

    // Сторінка авторизації
    @RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
    public String login(Model model) {

        return "login";
    }
    // Відображення інформації про акаунт
    @RequestMapping(value = { "/admin/accountInfo" }, method = RequestMethod.GET)
    public String accountInfo(Model model) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.isEnabled());

        model.addAttribute("userDetails", userDetails);
        return "accountInfo";
    }
    // Список замовлень
    @RequestMapping(value = { "/admin/orderList" }, method = RequestMethod.GET)
    public String orderList(Model model, //
                            @RequestParam(value = "page", defaultValue = "1") String pageStr) {
        int page = 1;
        try {
            page = Integer.parseInt(pageStr);
        } catch (Exception e) {
        }
        final int MAX_RESULT = 12;
        final int MAX_NAVIGATION_PAGE = 10;

        PaginationResult<OrderInfo> paginationResult //
                = orderDAO.listOrderInfo(page, MAX_RESULT, MAX_NAVIGATION_PAGE);

        model.addAttribute("paginationResult", paginationResult);
        return "orderList";
    }

    // Перегляд продукту
    @RequestMapping(value = { "/admin/product" }, method = RequestMethod.GET)
    public String product(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
        ProductForm productForm = null;

        if (code != null && code.length() > 0) {
            Product product = productDAO.findProduct(code);
            if (product != null) {
                productForm = new ProductForm(product);
            }
        }
        if (productForm == null) {
            productForm = new ProductForm();
            productForm.setNewProduct(true);
        }
        model.addAttribute("productForm", productForm);
        return "product";
    }

    //  Збереження продукту
    @RequestMapping(value = { "/admin/product" }, method = RequestMethod.POST)
    public String productSave(Model model, //
                              @ModelAttribute("productForm") @Validated ProductForm productForm, //
                              BindingResult result, //
                              final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "product";
        }
        try {
            productDAO.save(productForm);
        } catch (Exception e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            String message = rootCause.getMessage();
            model.addAttribute("errorMessage", message);
            // Перегляд форми продукту.
            return "product";
        }

        return "redirect:/productList";
    }

    @RequestMapping(value = "/admin/delete{code}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("code") String code, final RedirectAttributes redirectAttributes) {
        productDAO.delete(code);
        return "redirect:/productList";
    }


    // Перегляд покупок
    @RequestMapping(value = { "/admin/order" }, method = RequestMethod.GET)
    public String orderView(Model model, @RequestParam("orderId") String orderId) {
        OrderInfo orderInfo = null;
        if (orderId != null) {
            orderInfo = this.orderDAO.getOrderInfo(orderId);
        }
        if (orderInfo == null) {
            return "redirect:/admin/orderList";
        }
        List<OrderDetailInfo> details = this.orderDAO.listOrderDetailInfos(orderId);
        orderInfo.setDetails(details);

        model.addAttribute("orderInfo", orderInfo);

        return "order";
    }

}
