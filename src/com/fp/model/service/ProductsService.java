package com.fp.model.service;

import com.fp.model.entity.ProductEntity;
import com.fp.model.repository.ProductsRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsService {
    //singleton class
    private static final ProductsService productsService= new ProductsService();
    public static ProductsService getInstance(){return productsService;}
    private ProductsService(){}

    public ResultSet getProductsID() throws SQLException {
        ProductsRepository repository = new ProductsRepository();
        return repository.getProductsIDRepo();
    }
    public ProductEntity getProduct(int productID) throws SQLException {
        ProductsRepository repository = new ProductsRepository();
        String name = repository.getProductNameRepo(productID);
        int price = repository.getProductPriceRepo(productID);
        int quantity = repository.getProductQuantityRepo(productID);
        String category = repository.getProductCategoryRepo(productID);
        return new ProductEntity(productID,name,price,quantity,category);
    }
    public void addProduct(ProductEntity p) throws SQLException {
        ProductsRepository repository = new ProductsRepository();
        repository.addProductRepo(p);
    }
    public void deleteProduct(int productID) throws SQLException {
        ProductsRepository repository = new ProductsRepository();
        repository.deleteProductRepo(productID);
    }
    public void editProduct(ProductEntity editP) throws SQLException {
        ProductsRepository repository = new ProductsRepository();
        repository.editProductRepo(editP);
    }

    public ResultSet getProductsNumber(String category) throws SQLException {
        ProductsRepository repository = new ProductsRepository();
        return repository.getProductsNumberRepo(category);
    }

}
