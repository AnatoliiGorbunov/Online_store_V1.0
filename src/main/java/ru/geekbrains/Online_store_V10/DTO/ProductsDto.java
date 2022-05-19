package ru.geekbrains.Online_store_V10.DTO;

import lombok.Data;

@Data
public class ProductsDto {

    private Long id;
    private String title;
    private Long cost;

    public ProductsDto() {
    }

    public ProductsDto(Long id, String title, Long cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ProductsDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}

