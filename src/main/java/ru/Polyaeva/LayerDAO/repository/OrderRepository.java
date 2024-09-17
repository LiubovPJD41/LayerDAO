package ru.Polyaeva.LayerDAO.repository;

import java.util.List;

public interface OrderRepository {
    List<String> getProductName(String name);
}