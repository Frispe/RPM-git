package com.example.praktos3.graphicscard.service;

import com.example.praktos3.graphicscard.model.GraphicsCardModel;
import java.util.List;

public interface GraphicsCardService {
    List<GraphicsCardModel> findAllGraphicsCards();
    GraphicsCardModel findGraphicsCardById(long id);
    GraphicsCardModel findGraphicsCardByModel(String model);
    GraphicsCardModel addGraphicsCard(GraphicsCardModel card);
    GraphicsCardModel updateGraphicsCard(GraphicsCardModel card);
    void deleteGraphicsCard(long id);
    List<GraphicsCardModel> findGraphicsCardsWithPagination(int page, int size);
}