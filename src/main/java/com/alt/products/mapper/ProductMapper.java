package com.alt.products.mapper;

import com.alt.products.dto.ProductReqDTO;
import com.alt.products.dto.ProductResDTO;
import com.alt.products.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productReqDTOToProduct(ProductReqDTO productReqDTO);

    ProductResDTO productToProductResDTO(Product product);

    List<ProductResDTO> listProductToListProductResDTO(List<Product> products);

}
