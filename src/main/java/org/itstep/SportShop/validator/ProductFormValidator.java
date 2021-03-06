package org.itstep.SportShop.validator;

import org.itstep.SportShop.dao.ProductDAO;
import org.itstep.SportShop.entity.Product;
import org.itstep.SportShop.form.ProductForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductFormValidator implements Validator {

    public ProductFormValidator(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    private final ProductDAO productDAO;

    // Цей валідатор перевіряє лише ProductForm.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == ProductForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductForm productForm = (ProductForm) target;

        // Перевірка поля ProductForm.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "NotEmpty.productForm.brand");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "NotEmpty.productForm.color");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "NotEmpty.productForm.size");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");

        String code = productForm.getCode();
        if (code != null && code.length() > 0) {
            if (code.matches("\\s+")) {
                errors.rejectValue("code", "Pattern.productForm.code");
            } else if (productForm.isNewProduct()) {
                Product product = productDAO.findProduct(code);
                if (product != null) {
                    errors.rejectValue("code", "Duplicate.productForm.code");
                }
            }
        }
    }

}