package ru.geekbrains.Online_store_V10.DTO;

import lombok.Data;

@Data
public class CustomerDto {

    private Long id;
    private String name;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
